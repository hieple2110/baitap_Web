package com.hiep.dao;

import com.hiep.model.Account;
import com.hiep.model.Posts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostsDao  extends  DaoHelper implements BaseDao<Posts> {
    private final String SELECT_ALL = "SELECT * FROM posts where status = 0";
    private final String FIND_BY_ID = "SELECT * FROM posts where idPosts = ?";
    private final String INSERT_POSTS = "INSERT INTO posts ( image, title , shortContent , fullContent  )VALUES(?,?,?,?)";
    private final String UPDATE_POSTS = "UPDATE posts SET  image = ?, title = ?, shortContent = ?, fullContent = ? WHERE idPosts = ?";
    private final String DELETE_POSTS = "UPDATE posts SET status = 1 WHERE idPosts = ?";

    @Override
    public List<Posts> getAll() throws SQLException {
        List<Posts> listPosts = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idPosts");
                String image = resultSet.getString("image");
                String title = resultSet.getString("title");
                String shortContent = resultSet.getString("shortContent");
                String fullContent = resultSet.getString("fullContent");
                String status = resultSet.getString("status");
                Posts posts = new Posts(id,image,title, shortContent,fullContent, status);
                listPosts.add(posts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listPosts;
    }

    @Override
    public void insert(Posts posts) throws SQLException {
        connection();
        try (PreparedStatement statement = connec.prepareStatement(INSERT_POSTS)) {
            statement.setString(1, posts.getImage());
            statement.setString(2, posts.getTitle());
            statement.setString(3, posts.getShortContent());
            statement.setString(4, posts.getFullContent());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
    }

    @Override
    public boolean update(int id,Posts posts) throws SQLException {
        boolean rowUp = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(UPDATE_POSTS)) {
            statement.setString(1, posts.getImage());
            statement.setString(2, posts.getTitle());
            statement.setString(3, posts.getShortContent());
            statement.setString(4, posts.getFullContent());
            statement.setInt(5,id);
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
        try (PreparedStatement statement = connec.prepareStatement(DELETE_POSTS)) {
            statement.setInt(1, id);
            rowDel = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return rowDel;
    }

    @Override
    public Posts findById(int id) throws SQLException {
        Posts posts = null;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idPosts = resultSet.getInt("idPosts");
                String image = resultSet.getString("image");
                String title = resultSet.getString("title");
                String shortContent = resultSet.getString("shortContent");
                String fullContent = resultSet.getString("fullContent");
                String status = resultSet.getString("status");
                posts = new Posts(idPosts,image,title, shortContent,fullContent, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return posts;
    }
}
