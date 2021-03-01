package com.hiep.dao;

import com.hiep.model.Account;
import com.hiep.model.Education;
import com.hiep.model.Nation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NationDao extends DaoHelper implements BaseDao<Nation> {
    private final String SELECT_ALL = "SELECT * FROM nation where status = 0";
    private final String FIND_BY_ID = "SELECT * FROM nation where idNation = ?";
    private final String INSERT_NATION = "INSERT INTO nation ( nameNation ) VALUES(?)";
    private final String UPDATE_NATION = "UPDATE nation SET nameNation = ? WHERE idNation = ?";
    private final String DELETE_NATION = "UPDATE nation SET status = 1 WHERE idNation = ?";
    private final String DELETE_MISS = "UPDATE miss SET isDelete = 1 WHERE idMiss = ?;";

    @Override
    public List<Nation> getAll() throws SQLException {
        List<Nation> listNation = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idNation");
                String name = resultSet.getString("nameNation");
                String status = resultSet.getString("status");
                Nation education = new Nation(id, name, status);
                listNation.add(education);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listNation;
    }

    @Override
    public void insert(Nation nation) throws SQLException {
        connection();
        try (PreparedStatement statement = connec.prepareStatement(INSERT_NATION)) {
            statement.setString(1, nation.getNameNation());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
    }

    @Override
    public boolean update(int id, Nation nation) throws SQLException {
        boolean rowUp = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(UPDATE_NATION)) {
            statement.setString(1, nation.getNameNation());
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


            statement = connec.prepareStatement(DELETE_NATION);
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
    public Nation findById(int id) throws SQLException {
        Nation nation = null;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idNation = resultSet.getInt("idNation");
                String name = resultSet.getString("nameNation");
                String status = resultSet.getString("status");
                nation = new Nation(idNation, name, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return nation;
    }
}
