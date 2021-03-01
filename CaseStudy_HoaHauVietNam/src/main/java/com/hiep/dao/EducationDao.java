package com.hiep.dao;

import com.hiep.model.Education;
import com.hiep.model.Province;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDao extends DaoHelper implements BaseDao<Education> {
    private final String SELECT_ALL = "SELECT * FROM education where status = 0";
    private final String FIND_BY_ID = "SELECT * FROM education where idEducation = ?";
    private final String INSERT_EDUCATION = "INSERT INTO education ( nameEducation ) VALUES(?)";
    private final String UPDATE_EDUCATION = "UPDATE education SET nameEducation = ? WHERE idEducation = ?";
    private final String DELETE_EDUCATION = "UPDATE education SET status = 1 WHERE idEducation = ?";
    private final String DELETE_MISS = "UPDATE miss SET isDelete = 1 WHERE idMiss = ?;";

    @Override
    public List<Education> getAll() throws SQLException {
        List<Education> listEducation = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idEducation");
                String name = resultSet.getString("nameEducation");
                String status = resultSet.getString("status");
                Education education = new Education(id, name, status);
                listEducation.add(education);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listEducation;
    }

    @Override
    public void insert(Education education) throws SQLException {
        connection();
        try (PreparedStatement statement = connec.prepareStatement(INSERT_EDUCATION)) {
            statement.setString(1, education.getNameEducational());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
    }

    @Override
    public boolean update(int id,Education education) throws SQLException {
        boolean rowUp = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(UPDATE_EDUCATION)) {
            statement.setString(1, education.getNameEducational());
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

            statement = connec.prepareStatement(DELETE_EDUCATION);
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
    public Education findById(int id) throws SQLException {
        Education education = null;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idEducation = resultSet.getInt("idEducation");
                String name = resultSet.getString("nameEducation");
                String status = resultSet.getString("status");
                 education = new Education(idEducation, name, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return education;
    }
}
