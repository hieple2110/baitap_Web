package com.hiep.service;

import com.hiep.dao.ProvinceDao;
import com.hiep.model.Account;
import com.hiep.model.Province;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceService extends ValidateService implements BaseService<Province> {
    ProvinceDao provinceDao = new ProvinceDao();

    @Override
    public ArrayList<String> listResult(Province province) {
        ArrayList<String> listError = new ArrayList<>();
        if (!validateName(province.getNameProvince(), 3, 30)) {
            listError.add("Lỗi nhập tên Tỉnh thành");
        }
        if (listError.size() == 0) {
            listError.add("Thành công");
        }
        return listError;
    }

    @Override
    public List<Province> getAll() throws SQLException {
        return this.provinceDao.getAll();
    }

    @Override
    public ArrayList<String> insert(Province province) throws SQLException {
        ArrayList<String> listError = listResult(province);
        if (listError.size() == 1 && listError.get(0).equals("Thành công")) {
            if (checkDuplicate(province)) {
                listError.set(0, "Tỉnh thành đã đưuọc đăng ký");
            } else {
                this.provinceDao.insert(province);
            }
        } else {
            listError.remove("Thành công");
        }
        return listError;
    }

    @Override
    public ArrayList<String> update(int id, Province province) throws SQLException {
        ArrayList<String> listError = listResult(province);
        Province province1 = this.provinceDao.findById(id);
        if (listError.get(0).equals("Thành công")) {
            if (province1.getNameProvince().equals(province.getNameProvince())) {
                listError.set(0, "Không thực hiện chỉnh sửa gì");
            } else if (checkDuplicate(province)) {
                listError.set(0, "Nội dung chỉnh sửa đã bị trùng");
            } else {
                this.provinceDao.update(id, province);
            }
        }
        return listError;
    }

    @Override
    public String delete(int id) throws SQLException {
        if (this.provinceDao.delete(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa không thành công";
        }
    }

    @Override
    public Province findById(int id) throws SQLException {
        return this.provinceDao.findById(id);
    }

    @Override
    public boolean checkDuplicate(Province province) throws SQLException {
        ArrayList<Province> listProvince = new ArrayList<>(getAll());
        for (Province province1 : listProvince) {
            if (province1.getNameProvince().equals(province.getNameProvince())) {
                return true;
            }
        }
        return false;
    }


    public List<Province> listPage(int total) throws SQLException {
        return this.provinceDao.listPage(total);
    }
}
