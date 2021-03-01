package com.hiep.service;


import com.hiep.dao.EducationDao;
import com.hiep.model.Education;
import com.hiep.model.Nation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationService extends  ValidateService implements BaseService<Education> {
    EducationDao educationDao = new EducationDao();
    @Override
    public ArrayList<String> listResult(Education education) {
        ArrayList<String> listError = new ArrayList<>();
        if (!validateName(education.getNameEducational(), 3, 30)) {
            listError.add("Lỗi nhập tên Học vấn");
        }
        if (listError.size() == 0) {
            listError.add("Thành công");
        }
        return listError;
    }

    @Override
    public List<Education> getAll() throws SQLException {
        return this.educationDao.getAll();
    }

    @Override
    public ArrayList<String> insert(Education education) throws SQLException {
        ArrayList<String> listError = listResult(education);
        if (listError.size() == 1 && listError.get(0).equals("Thành công")) {
            if (checkDuplicate(education)) {
                listError.set(0, "Tên Trìn độ học vấn đã được đăng ký");
            } else {
                this.educationDao.insert(education);
            }
        } else {
            listError.remove("Thành công");
        }
        return listError;
    }

    @Override
    public ArrayList<String> update(int id, Education education) throws SQLException {
        ArrayList<String> listError = listResult(education);
        Education education1 = this.educationDao.findById(id);
        if (listError.get(0).equals("Thành công")) {
            if (education1.getNameEducational().equals(education.getNameEducational())) {
                listError.set(0, "Không thực hiện chỉnh sửa gì");
            }else if(checkDuplicate(education)){
                listError.set(0, "Nội dung chỉnh sửa đã bị trùng");
            } else {
                this.educationDao.update(id, education);
            }
        }
        return listError;
    }

    @Override
    public String delete(int id) throws SQLException {
        if (this.educationDao.delete(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa không thành công";
        }
    }

    @Override
    public Education findById(int id) throws SQLException {
        return this.educationDao.findById(id);
    }

    @Override
    public boolean checkDuplicate(Education education) throws SQLException {
        ArrayList<Education> listEducation = new ArrayList<>(getAll());
        for (Education education1 : listEducation){
            if (education1.getNameEducational().equals(education.getNameEducational())){
                return true;
            }
        }
        return false;
    }
}
