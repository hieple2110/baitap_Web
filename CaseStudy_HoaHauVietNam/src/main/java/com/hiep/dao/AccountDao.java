package com.hiep.dao;

import com.hiep.model.Account;
import com.hiep.model.Nation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends DaoHelper implements BaseDao<Account> {
    private final String SELECT_ALL = "SELECT * FROM account where status = 0";
    private final String FIND_BY_ID = "SELECT * FROM account where idAccount = ?";
    private final String INSERT_ACCOUNT = "INSERT INTO account ( image, userName , passWord , fullName , email,decentralization  )VALUES(?,?,?,?,?,?)";
    private final String UPDATE_ACCOUNT = "UPDATE account SET  image = ?, userName = ?, passWord = ?, fullName = ?, email = ?,decentralization=? WHERE idAccount = ?";
    private final String DELETE_ACCOUNT = "UPDATE account SET status = 1 WHERE idAccount = ?";
    private final String FIND_USER_PASS = "SELECT * FROM account WHERE userName = ? and passWord = ?";


    public Account findUserPass(String user, String pass) throws SQLException {
        Account account = null;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(FIND_USER_PASS)) {
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idAccount = resultSet.getInt("idAccount");
                String image = resultSet.getString("image");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("passWord");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String decentralization = resultSet.getString("decentralization");
                String status = resultSet.getString("status");
                account = new Account(idAccount, image, userName, passWord, fullName, email, decentralization, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return account;
    }


    @Override
    public List<Account> getAll() throws SQLException {
        List<Account> listAccount = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idAccount = resultSet.getInt("idAccount");
                String image = resultSet.getString("image");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("passWord");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String decentralization = resultSet.getString("decentralization");
                String status = resultSet.getString("status");
                Account account = new Account(idAccount, image, userName, passWord, fullName, email, decentralization, status);
                listAccount.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listAccount;
    }

    @Override
    public void insert(Account account) throws SQLException {
        connection();
        try (PreparedStatement statement = connec.prepareStatement(INSERT_ACCOUNT)) {
            statement.setString(1, account.getImage());
            statement.setString(2, account.getUserName());
            statement.setString(3, account.getPassWord());
            statement.setString(4, account.getFullName());
            statement.setString(5, account.getEmail());
            statement.setString(6, account.getDecentralization());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
    }

    @Override
    public boolean update(int id, Account account) throws SQLException {
        boolean rowUp = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(UPDATE_ACCOUNT)) {
            statement.setString(1, account.getImage());
            statement.setString(2, account.getUserName());
            statement.setString(3, account.getPassWord());
            statement.setString(4, account.getFullName());
            statement.setString(5, account.getEmail());
            statement.setString(6, account.getDecentralization());
            statement.setInt(7, id);
            rowUp = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return rowUp;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDel = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(DELETE_ACCOUNT)) {
            statement.setInt(1, id);
            rowDel = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return rowDel;
    }

    @Override
    public Account findById(int id) throws SQLException {
        Account account = null;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idAccount = resultSet.getInt("idAccount");
                String image = resultSet.getString("image");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("passWord");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String decentralization = resultSet.getString("decentralization");
                String status = resultSet.getString("status");
                account = new Account(idAccount, image, userName, passWord, fullName, email, decentralization,status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return account;
    }
}
