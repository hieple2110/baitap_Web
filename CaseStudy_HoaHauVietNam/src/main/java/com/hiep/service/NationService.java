package com.hiep.service;

import com.hiep.dao.NationDao;
import com.hiep.model.Account;
import com.hiep.model.Nation;
import com.hiep.model.Posts;

import javax.print.attribute.standard.MediaSize;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NationService extends  ValidateService implements BaseService<Nation> {
    NationDao nationDao = new NationDao();
    @Override
    public ArrayList<String> listResult(Nation nation) {
        ArrayList<String> listError = new ArrayList<>();
        if (!validateName(nation.getNameNation(), 3, 20)) {
            listError.add("Lỗi nhập tên Dân tộc");
        }
        if (listError.size() == 0) {
            listError.add("Thành công");
        }
        return listError;
    }

    @Override
    public List<Nation> getAll() throws SQLException {
        return this.nationDao.getAll();
    }

    @Override
    public ArrayList<String> insert(Nation nation) throws SQLException {
        ArrayList<String> listError = listResult(nation);
        if (listError.size() == 1 && listError.get(0).equals("Thành công")) {
            if (checkDuplicate(nation)) {
                listError.set(0, "Tên này đã được đăng ký");
            } else {
                this.nationDao.insert(nation);
            }
        } else {
            listError.remove("Thành công");
        }
        return listError;
    }

    @Override
    public ArrayList<String> update(int id, Nation nation) throws SQLException {
        ArrayList<String> listError = listResult(nation);
        Nation nation1 = this.nationDao.findById(id);
        if (listError.get(0).equals("Thành công")) {
            if (nation1.getNameNation().equals(nation.getNameNation())) {
                listError.set(0, "Không thực hiện chỉnh sửa gì");
            } else if (checkDuplicate(nation)) {
                listError.set(0, "Nội dung chỉnh sửa đã bị trùng");
            } else {
                this.nationDao.update(id, nation);
            }
        }
        return listError;
    }

    @Override
    public String delete(int id) throws SQLException {
        if (this.nationDao.delete(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa không thành công";
        }
    }

    @Override
    public Nation findById(int id) throws SQLException {
        return this.nationDao.findById(id);
    }

    @Override
    public boolean checkDuplicate(Nation nation) throws SQLException {
        ArrayList<Nation> listNation = new ArrayList<>(getAll());
        for (Nation nation1 : listNation){
            if (nation1.getNameNation().equals(nation.getNameNation())){
                return true;
            }
        }
        return false;
    }
}
