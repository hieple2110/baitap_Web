package com.hiep.service;

import com.hiep.dao.AccountDao;
import com.hiep.model.Account;
import com.hiep.model.Education;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService extends ValidateService implements BaseService<Account> {
    AccountDao accountDao = new AccountDao();

    @Override
    public ArrayList<String> listResult(Account account) {
        ArrayList<String> listError = new ArrayList<>();
        if (!validateLength(account.getUserName(), 4, 30)) {
            listError.add("Lỗi nhập tên Tài khoản");
        }
        if (!validatePassword(account.getPassWord())) {
            listError.add("Lỗi nhập mật khẩu");
        }
        if (!validateLength(account.getFullName(), 5, 40)) {
            listError.add("Lỗi nhập Họ và tên người dùng");
        }
        if (!validateEmail(account.getEmail())) {
            listError.add("Lỗi nhập Email người dùng");
        }
        if (listError.size() == 0) {
            listError.add("Thành công");
        }
        return listError;
    }

    @Override
    public List<Account> getAll() throws SQLException {
        return this.accountDao.getAll();
    }

    @Override
    public ArrayList<String> insert(Account account) throws SQLException {
        ArrayList<String> listError = listResult(account);
        if (listError.size() == 1 && listError.get(0).equals("Thành công")) {
            if (checkDuplicate(account)) {
                listError.set(0, "Tên Tài khoản đã được đăng ký");
            } else {
                this.accountDao.insert(account);
            }
        } else {
            listError.remove("Thành công");
        }
        return listError;
    }

    @Override
    public ArrayList<String> update(int id, Account account) throws SQLException {
        ArrayList<String> listError = listResult(account);
        Account account1 = this.accountDao.findById(id);
        if (listError.get(0).equals("Thành công")) {
            if (account1.getUserName().equals(account.getUserName())
                    && account1.getPassWord().equals(account.getPassWord())
                    && account1.getFullName().equals(account.getFullName())
                    && account1.getEmail().equals(account.getEmail())
                    && account1.getImage().equals(account.getImage())) {
                listError.set(0, "Không thực hiện chỉnh sửa gì");
            } else  {
                this.accountDao.update(id, account);
            }
        }
        return listError;
    }

    @Override
    public String delete(int id) throws SQLException {
        if (this.accountDao.delete(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa không thành công";
        }
    }

    @Override
    public Account findById(int id) throws SQLException {
        return this.accountDao.findById(id);
    }

    public Account findUserPass(String user, String pass) throws SQLException {
        return this.accountDao.findUserPass(user,pass);
    }

    public boolean checkUser(String user,String pass) throws SQLException {
        List<Account> listAccount = getAll();
        for (Account account : listAccount) {
            if (user.equals(account.getUserName())&& pass.equals(account.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkDuplicate(Account account) throws SQLException {
        ArrayList<Account> listAccount = new ArrayList<>(getAll());
        for (Account account1 : listAccount) {
            if (account1.getUserName().equals(account.getUserName())    ) {
                return true;
            }
        }
        return false;
    }
}
