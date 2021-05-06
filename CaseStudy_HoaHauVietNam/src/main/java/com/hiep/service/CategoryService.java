package com.hiep.service;

import com.hiep.dao.BaseDao;
import com.hiep.dao.CategoryDao;
import com.hiep.model.Category;
import com.hiep.model.Nation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService extends  ValidateService implements BaseService<Category> {
    CategoryDao categoryDao = new CategoryDao();


    @Override
    public ArrayList<String> listResult(Category category) {
        ArrayList<String> listError = new ArrayList<>();
        if (!validateName(category.getNameCategory(), 3, 20)) {
            listError.add("Lỗi nhập tên Dân tộc");
        }
        if (listError.size() == 0) {
            listError.add("Thành công");
        }
        return listError;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        return this.categoryDao.getAll();
    }

    @Override
    public ArrayList<String> insert(Category category) throws SQLException {
        ArrayList<String> listError = listResult(category);
        if (listError.size() == 1 && listError.get(0).equals("Thành công")) {
            if (checkDuplicate(category)) {
                listError.set(0, "Tên này đã được đăng ký");
            } else {
                this.categoryDao.insert(category);
            }
        } else {
            listError.remove("Thành công");
        }
        return listError;
    }

    @Override
    public ArrayList<String> update(int id, Category category) throws SQLException {
        ArrayList<String> listError = listResult(category);
        Category category1 = this.categoryDao.findById(id);
        if (listError.get(0).equals("Thành công")) {
            if (category1.getNameCategory().equals(category.getNameCategory())) {
                listError.set(0, "Không thực hiện chỉnh sửa gì");
            } else if (checkDuplicate(category)) {
                listError.set(0, "Nội dung chỉnh sửa đã bị trùng");
            } else {
                this.categoryDao.update(id, category);
            }
        }
        return listError;
    }

    @Override
    public String delete(int id) throws SQLException {
        if (this.categoryDao.delete(id)){
            return "<script>\n" +
                    "    alert(\"Xóa Thành công\")\n" +
                    "</script>";
        }else {
            return "<script>\n" +
                    "    alert(\"Xóa không thành công\")\n" +
                    "</script>";
        }
    }

    @Override
    public Category findById(int id) throws SQLException {
        return this.categoryDao.findById(id);
    }

    @Override
    public boolean checkDuplicate(Category category) throws SQLException {
        ArrayList<Category> listCategory = new ArrayList<>(getAll());
        for (Category category1 : listCategory){
            if (category1.getNameCategory().equals(category.getNameCategory())){
                return true;
            }
        }
        return false;
    }
}
