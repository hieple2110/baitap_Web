package com.hiep.service;

import com.hiep.dao.PostsDao;
import com.hiep.model.Account;
import com.hiep.model.Posts;
import com.hiep.model.Province;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostsService extends  ValidateService implements BaseService<Posts> {
    PostsDao postsDao = new PostsDao();

    @Override
    public ArrayList<String> listResult(Posts posts) {
        ArrayList<String> listError = new ArrayList<>();
        if (!validateLength(posts.getTitle(), 10, 200)) {
            listError.add("Lỗi nhập tên Tiêu đề");
        }
        if (!validateLength(posts.getShortContent(), 20, 500)) {
            listError.add("Lỗi nhập tóm tắt nội dung");
        }
        if (listError.size() == 0) {
            listError.add("Thành công");
        }
        return listError;
    }

    @Override
    public List<Posts> getAll() throws SQLException {
        return this.postsDao.getAll();
    }

    @Override
    public ArrayList<String> insert(Posts posts) throws SQLException {
        ArrayList<String> listError = listResult(posts);
        if (listError.size() == 1 && listError.get(0).equals("Thành công")) {
            if (checkDuplicate(posts)) {
                listError.set(0, "Bài viết đã đươc đăng");
            } else {
                this.postsDao.insert(posts);
            }
        } else {
            listError.remove("Thành công");
        }
        return listError;
    }

    @Override
    public ArrayList<String> update(int id, Posts posts) throws SQLException {
        ArrayList<String> listError = listResult(posts);
        Posts posts1 = this.postsDao.findById(id);
        if (listError.get(0).equals("Thành công")) {
            if (posts1.getTitle().equals(posts.getTitle()) && posts1.getShortContent().equals(posts.getShortContent())
                    && posts1.getFullContent().equals(posts.getFullContent()) && posts1.getImage().equals(posts.getImage())) {
                listError.set(0, "Không thực hiện chỉnh sửa gì");
            }else if(posts1.getImage().equals(posts.getImage())){
                listError.set(0, "Nội dung Ảnh đã bị trùng.");
            }else if(posts1.getTitle().equals(posts.getTitle())){
                listError.set(0, "Nội dung Tiêu đề  đã bị trùng.");
            }else if(posts1.getShortContent().equals(posts.getShortContent())){
                listError.set(0, "Nội dung Tóm tắt đã bị trùng.");
            }else if(posts1.getFullContent().equals(posts.getFullContent())){
                listError.set(0, "Nội dung bài viết đã bị trùng.");
            }
            else {
                this.postsDao.update(id, posts);
            }
        }
        return listError;
    }

    @Override
    public String delete(int id) throws SQLException {
        if (this.postsDao.delete(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa không thành công";
        }
    }

    @Override
    public Posts findById(int id) throws SQLException {
        return this.postsDao.findById(id);
    }

    @Override
    public boolean checkDuplicate(Posts posts) throws SQLException {
        ArrayList<Posts> listPosts = new ArrayList<>(getAll());
        for (Posts posts1 : listPosts){
            if (posts1.getTitle().equals(posts.getTitle()) && posts1.getShortContent().equals(posts.getShortContent())
                    && posts1.getFullContent().equals(posts.getFullContent()) && posts1.getImage().equals(posts.getImage())){
                return true;
            }
        }
        return false;
    }
}
