package com.hiep.dao;

import com.hiep.model.Category;
import com.hiep.model.Nation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends DaoHelper implements BaseDao<Category> {
    private final String SELECT_ALL = "SELECT * FROM category where status = 0;";
    private final String FIND_BY_ID = "SELECT * FROM category where idCategory = ? and status = 0";
    private final String INSERT_CATEGORY = "INSERT INTO category (nameCategory) VALUES (?)";
    private final String UPDATE_CATEGORY = "UPDATE category SET nameCategory = ? WHERE idCategory = ?;";
    private final String DELETE_CATEGORY = "UPDATE category SET status = 1 WHERE idCategory = ?;";

    @Override
    public List<Category> getAll() throws SQLException {
        List<Category> listCategory = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                String status = resultSet.getString("status");
                Category category = new Category(id, name, status);
                listCategory.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listCategory;
    }

    @Override
    public void insert(Category category) throws SQLException {
        connection();
        try (PreparedStatement statement = connec.prepareStatement(INSERT_CATEGORY)) {
            statement.setString(1, category.getNameCategory());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
    }

    @Override
    public boolean update(int id, Category category) throws SQLException {
        boolean rowUp = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(UPDATE_CATEGORY)) {
            statement.setString(1, category.getNameCategory());
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
            PreparedStatement statement = connec.prepareStatement(DELETE_CATEGORY);
            statement.setInt(1, id);
            rowDel = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return rowDel;
    }

    @Override
    public Category findById(int id) throws SQLException {
        Category category = null;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                String status = resultSet.getString("status");
                category = new Category(idCategory, name, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return category;
    }
}
