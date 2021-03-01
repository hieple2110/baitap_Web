package com.hiep.service;

import com.hiep.dao.MissDao;
import com.hiep.model.Account;
import com.hiep.model.Miss;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MissService extends ValidateService implements BaseService<Miss> {
    MissDao missDao = new MissDao();

    @Override
    public ArrayList<String> listResult(Miss miss) {
        ArrayList<String> listError = new ArrayList<>();
        if (!validateName(miss.getNameMiss(), 5, 50)) {
            listError.add("Lỗi nhập tên Thí sinh");
        }
        if (!validateLength(miss.getAddress(), 10, 80)) {
            listError.add("Lỗi nhập Địa chỉ");
        }
        if (!validateLength(miss.getPassPort(), 8, 12)) {
            listError.add("Lỗi nhập số CMND");
        }
        if (!validateName(miss.getJob(), 5, 30)) {
            listError.add("Lỗi nhập tên Nghề nghiệp");
        }
        if (!validateEmail(miss.getEmail())) {
            listError.add("Lỗi nhập Email");
        }
        if (!validateNumberPhone(miss.getNumberPhone())) {
            listError.add("Lỗi nhập Số điện thoại");
        }
        if (listError.size() == 0) {
            listError.add("Thành công");
        }
        return listError;
    }

    @Override
    public List<Miss> getAll() throws SQLException {
        return this.missDao.getAll();
    }

    public List<Miss> listMissLoai() throws SQLException {
        return this.missDao.listMissLoai();
    }

    public List<Miss> listMissDuyet() throws SQLException {
        return this.missDao.listMissDuyet();
    }

    public List<Miss> listSearch(String name) throws SQLException {
        return this.missDao.listSearch(name);
    }

    public List<Miss> listMissCho() throws SQLException {
        return this.missDao.listMissChoDuyet();
    }

    public List<Miss> listPage(int total) throws SQLException {
        return this.missDao.listPage(total);
    }

    @Override
    public ArrayList<String> insert(Miss miss) throws SQLException {
        ArrayList<String> listError = listResult(miss);
        ArrayList<Miss> listMiss = new ArrayList<>(getAll());
        for (Miss miss1 : listMiss) {
            if (miss1.getPassPort().equals(miss.getPassPort())) {
                listError.add("CMND đã được đăng ký");
            }
            if (miss1.getNumberPhone().equals(miss.getNumberPhone())) {
                listError.add("Số điện thoại đã được đăng ký");
            }
            if (miss1.getEmail().equals(miss.getEmail())) {
                listError.add("Email đã được đăng ký");
            }
        }

        if (listError.size() == 1 && listError.get(0).equals("Thành công")) {
            if (checkDuplicate(miss)) {
                listError.set(0, "Đã tồn tại Thí sinh này");
            } else {
                this.missDao.insert(miss);
            }
        } else {
            listError.remove("Thành công");
        }

        return listError;
    }

    @Override
    public ArrayList<String> update(int id, Miss miss) throws SQLException {
        ArrayList<String> listError = listResult(miss);
        Miss miss1 = this.missDao.findById(id);
        if (listError.get(0).equals("Thành công")) {
            if (checkUpdate(miss)) {
                listError.set(0, "Không thực hiện chỉnh sửa gì");
            } else {
                this.missDao.update(id, miss);
            }
        }
        return listError;
    }

    @Override
    public String delete(int id) throws SQLException {
        Miss miss = missDao.findById(id);
        if (!miss.getStatus().equalsIgnoreCase("Đã duyệt")) {
            if (missDao.delete(id)) {
                return "Xóa thành công";
            } else {
                return "Xóa không thành công";
            }
        }
        return "Thí sinh này đã được duyệt. Không thể xóa";
    }

    public String delete_miss_province(int id) throws SQLException {
        if (missDao.delete_miss_province(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa không thành công";
        }
    }

    public String delete_miss_nation(int id) throws SQLException {
        Miss miss = missDao.findById(id);
        if (!miss.getStatus().equalsIgnoreCase("Đã duyệt")) {
            if (missDao.delete_miss_nation(id)) {
                return "Xóa thành công";
            } else {
                return "Xóa không thành công";
            }
        }
        return "Thí sinh này đã được duyệt. Không thể xóa";
    }

    public String delete_miss_education(int id) throws SQLException {
        Miss miss = missDao.findById(id);
        if (!miss.getStatus().equalsIgnoreCase("Đã duyệt")) {
            if (missDao.delete_miss_education(id)) {
                return "Xóa thành công";
            } else {
                return "Xóa không thành công";
            }
        }
        return "Thí sinh này đã được duyệt. Không thể xóa";
    }

    @Override
    public Miss findById(int id) throws SQLException {
        return this.missDao.findById(id);
    }

    @Override
    public boolean checkDuplicate(Miss miss) throws SQLException {
        ArrayList<Miss> listMiss = new ArrayList<>(getAll());
        for (Miss miss1 : listMiss) {
            if (miss1.getPassPort().equals(miss.getPassPort())
                    || miss1.getNumberPhone().equals(miss.getNumberPhone())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUpdate(Miss miss) throws SQLException {
        ArrayList<Miss> listMiss = new ArrayList<>(getAll());
        for (Miss miss1 : listMiss) {
            if (miss1.getNameMiss().equals(miss.getNameMiss()) &&
                    miss1.getDateOfBirth().equals(miss.getDateOfBirth()) &&
                    miss1.getPassPort().equals(miss.getPassPort()) &&
                    miss1.getAddress().equals(miss.getAddress()) &&
                    miss1.getJob().equals(miss.getJob()) &&
                    miss1.getEmail().equals(miss.getEmail()) &&
                    miss1.getNumberPhone().equals(miss.getNumberPhone()) &&
                    miss1.getIdProvince() == (miss.getIdProvince()) &&
                    miss1.getIdNation() == (miss.getIdNation()) &&
                    miss1.getIdEducational() == (miss.getIdEducational()) &&
                    miss1.getImage().equals(miss.getImage()) &&
                    miss1.getStatus().equals(miss.getStatus())) {
                return true;
            }
        }
        return false;
    }


}
