package com.hiep.dao;


import com.hiep.model.Education;
import com.hiep.model.Miss;
import com.hiep.model.Nation;
import com.hiep.model.Province;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDao extends DaoHelper implements BaseDao<Province> {
    private final String SELECT_ALL = "SELECT * FROM province where status = 0";
    private final String FIND_BY_ID = "SELECT * FROM province where idProvince = ?";
    private final String INSERT_PROVINCE = "INSERT INTO province ( nameProvince ) VALUES(?)";
    private final String UPDATE_PROVINCE = "UPDATE province SET nameProvince = ? WHERE idProvince = ?";
    private final String DELETE_PROVINCE = "UPDATE province SET status = 1 WHERE idProvince = ?";
    private final String DELETE_MISS = "UPDATE miss SET isDelete = 1 WHERE idMiss = ?;";
    private final String list_page = "select * from province where status = 0 limit ?,10";

    public List<Province> listPage(int total) throws SQLException {
        List<Province> listPage = new ArrayList<>();
        connection();
        PreparedStatement statement = connec.prepareStatement(list_page);
        statement.setInt(1, total*10-10);
        try {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idProvince");
                String name = resultSet.getString("nameProvince");
                String status = resultSet.getString("status");
                Province province = new Province(id, name, status);
                listPage.add(province);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPage;
    }

    public int getNumberPage() throws SQLException {
        String query = "select count(*) from province;";
        connection();
        PreparedStatement preparedStatement = connec.prepareStatement(query);
        try {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 10;
                if (total % 10 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } finally {

        }
        return 0;
    }

    @Override
    public List<Province> getAll() throws SQLException {
        List<Province> listProvince = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idProvince");
                String name = resultSet.getString("nameProvince");
                String status = resultSet.getString("status");
                Province province = new Province(id, name, status);
                listProvince.add(province);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listProvince;
    }

    @Override
    public void insert(Province province) throws SQLException {
        connection();
        try (PreparedStatement statement = connec.prepareStatement(INSERT_PROVINCE)) {
            statement.setString(1, province.getNameProvince());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
    }

    @Override
    public boolean update(int id, Province province) throws SQLException {
        boolean rowUp = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(UPDATE_PROVINCE)) {
            statement.setString(1, province.getNameProvince());
            statement.setInt(2, id);
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
        try {
            connection();
            PreparedStatement statement = connec.prepareStatement(DELETE_MISS);
            statement.setInt(1, id);
            connec.setAutoCommit(false);

            statement = connec.prepareStatement(DELETE_PROVINCE);
            statement.setInt(1, id);
            rowDel = statement.executeUpdate() > 0;
            connec.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
            connec.rollback();
            connec.close();
        }
        disconnection();
        return rowDel;
    }

    @Override
    public Province findById(int id) throws SQLException {
        Province province = null;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idProvince = resultSet.getInt("idProvince");
                String name = resultSet.getString("nameProvince");
                String status = resultSet.getString("status");
                province = new Province(idProvince, name, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return province;
    }
}

