package com.hiep.dao;

import com.hiep.model.Account;
import com.hiep.model.Category;
import com.hiep.model.Posts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostsDao extends DaoHelper implements BaseDao<Posts> {
    private final String SELECT_ALL = "call list_all_posts()";
    private final String FIND_BY_ID = "SELECT posts.*, category.nameCategory FROM posts inner join category on posts.idCategory = category.idCategory\n" +
            "and( posts.status = 0 and posts.idPosts = ?)";
    private final String INSERT_POSTS = "INSERT INTO posts ( image, title , shortContent , fullContent, idCategory  )VALUES(?,?,?,?,?)";
    private final String UPDATE_POSTS = "UPDATE posts SET  image = ?, title = ?, shortContent = ?, fullContent = ?, idCategory = ? WHERE idPosts = ?";
    private final String DELETE_POSTS = "UPDATE posts SET status = 1 WHERE idPosts = ?";
    private final String TOP_3 = "call posts_top_3()";
    private final String TOP_8 = "call posts_top_8()";
    private final String TOP_10 = "call posts_top_10()";
    private final String LIST_DONORS = "call list_donors()";
    private final String LIST_POSTS_MISS = "call list_posts_miss();";
    private final String LIST_POSTS_ROUND = "call list_posts_roundCompetition();";
    private final String LIST_ACTIVITIES = "call list_activities();";
    private  final String LIKE = "UPDATE  posts SET likePosts = likePosts + 1 WHERE idPosts = ?";
    private  final String VIEW = "UPDATE  posts SET view = view + 1 WHERE idPosts = ?";

    @Override
    public List<Posts> getAll() throws SQLException {
        List<Posts> listPosts = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(SELECT_ALL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idPosts = rs.getInt("idPosts");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String shortContent = rs.getString("shortContent");
                String fullContent = rs.getString("fullContent");
                String datePosts = rs.getString("datePosts");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(datePosts, formatter);
                int idCategory = rs.getInt("idCategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                String status = rs.getString("status");
                int like = rs.getInt("likePosts");
                int view = rs.getInt("view");
                Posts posts = new Posts(idPosts, image, title, shortContent, fullContent, dateTime, idCategory, category, status, like, view);
                listPosts.add(posts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listPosts;
    }

    public List<Posts> top_3() throws SQLException {
        List<Posts> listTop3 = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(TOP_3)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idPosts = rs.getInt("idPosts");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String shortContent = rs.getString("shortContent");
                String fullContent = rs.getString("fullContent");
                String datePosts = rs.getString("datePosts");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(datePosts, formatter);
                int idCategory = rs.getInt("idCategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                String status = rs.getString("status");
                int like = rs.getInt("likePosts");
                int view = rs.getInt("view");
              Posts  posts = new Posts(idPosts, image, title, shortContent, fullContent, dateTime, idCategory, category, status, like,view);
                listTop3.add(posts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listTop3;
    }

    public List<Posts> top_8() throws SQLException {
        List<Posts> listTop8 = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(TOP_8)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idPosts = rs.getInt("idPosts");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String shortContent = rs.getString("shortContent");
                String fullContent = rs.getString("fullContent");
                String datePosts = rs.getString("datePosts");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(datePosts, formatter);
                int idCategory = rs.getInt("idCategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                String status = rs.getString("status");
                int like = rs.getInt("likePosts");
                int view = rs.getInt("view");
               Posts posts = new Posts(idPosts, image, title, shortContent, fullContent, dateTime, idCategory, category, status, like,view);
                listTop8.add(posts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listTop8;
    }

    public List<Posts> top_10() throws SQLException {
        List<Posts> listTop10 = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(TOP_10)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idPosts = rs.getInt("idPosts");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String shortContent = rs.getString("shortContent");
                String fullContent = rs.getString("fullContent");
                String datePosts = rs.getString("datePosts");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(datePosts, formatter);
                int idCategory = rs.getInt("idCategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                String status = rs.getString("status");
                int like = rs.getInt("likePosts");
                int view = rs.getInt("view");
              Posts  posts = new Posts(idPosts, image, title, shortContent, fullContent, dateTime, idCategory, category, status, like,view);
                listTop10.add(posts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listTop10;
    }

    public List<Posts> listDonors() throws SQLException {
        List<Posts> listTop8 = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(LIST_DONORS) ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idPosts = rs.getInt("idPosts");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String shortContent = rs.getString("shortContent");
                String fullContent = rs.getString("fullContent");
                String datePosts = rs.getString("datePosts");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(datePosts, formatter);
                int idCategory = rs.getInt("idCategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                String status = rs.getString("status");
                int like = rs.getInt("likePosts");
                int view = rs.getInt("view");
              Posts  posts = new Posts(idPosts, image, title, shortContent, fullContent, dateTime, idCategory, category, status, like,view);
                listTop8.add(posts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listTop8;
    }

    public List<Posts> listPostMiss() throws SQLException {
        List<Posts> listPostMiss = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(LIST_POSTS_MISS) ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idPosts = rs.getInt("idPosts");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String shortContent = rs.getString("shortContent");
                String fullContent = rs.getString("fullContent");
                String datePosts = rs.getString("datePosts");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(datePosts, formatter);
                int idCategory = rs.getInt("idCategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                String status = rs.getString("status");
                int like = rs.getInt("likePosts");
                int view = rs.getInt("view");
               Posts posts = new Posts(idPosts, image, title, shortContent, fullContent, dateTime, idCategory, category, status, like,view);
               listPostMiss.add(posts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listPostMiss;
    }

    public List<Posts> listPostsRound() throws SQLException {
        List<Posts> listPostsRound = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(LIST_POSTS_ROUND) ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idPosts = rs.getInt("idPosts");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String shortContent = rs.getString("shortContent");
                String fullContent = rs.getString("fullContent");
                String datePosts = rs.getString("datePosts");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(datePosts, formatter);
                int idCategory = rs.getInt("idCategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                String status = rs.getString("status");
                int like = rs.getInt("likePosts");
                int view = rs.getInt("view");
              Posts  posts = new Posts(idPosts, image, title, shortContent, fullContent, dateTime, idCategory, category, status, like,view);
                listPostsRound.add(posts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listPostsRound;
    }

    public List<Posts> listActivities() throws SQLException {
        List<Posts> listActivities = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(LIST_ACTIVITIES) ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idPosts = rs.getInt("idPosts");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String shortContent = rs.getString("shortContent");
                String fullContent = rs.getString("fullContent");
                String datePosts = rs.getString("datePosts");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(datePosts, formatter);
                int idCategory = rs.getInt("idCategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                String status = rs.getString("status");
                int like = rs.getInt("likePosts");
                int view = rs.getInt("view");
                Posts posts = new Posts(idPosts, image, title, shortContent, fullContent, dateTime, idCategory, category, status, like,view);
                listActivities.add(posts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return listActivities;
    }

    @Override
    public void insert(Posts posts) throws SQLException {
        connection();
        try (PreparedStatement statement = connec.prepareStatement(INSERT_POSTS)) {
            statement.setString(1, posts.getImage());
            statement.setString(2, posts.getTitle());
            statement.setString(3, posts.getShortContent());
            statement.setString(4, posts.getFullContent());
            statement.setInt(5, posts.getIdCategory());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
    }

    @Override
    public boolean update(int id, Posts posts) throws SQLException {
        boolean rowUp = false;
        connection();
        try (PreparedStatement statement = connec.prepareStatement(UPDATE_POSTS)) {
            statement.setString(1, posts.getImage());
            statement.setString(2, posts.getTitle());
            statement.setString(3, posts.getShortContent());
            statement.setString(4, posts.getFullContent());
            statement.setInt(5, posts.getIdCategory());
            statement.setInt(6, id);
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
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idPosts = rs.getInt("idPosts");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String shortContent = rs.getString("shortContent");
                String fullContent = rs.getString("fullContent");
                String datePosts = rs.getString("datePosts");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(datePosts, formatter);
                int idCategory = rs.getInt("idCategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                String status = rs.getString("status");
                int like = rs.getInt("likePosts");
                int view = rs.getInt("view");
                posts = new Posts(idPosts, image, title, shortContent, fullContent, dateTime, idCategory, category, status, like,view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        disconnection();
        return posts;
    }

    public  void likePosts(int id){
        connection();
        try (PreparedStatement statement = connec.prepareStatement(LIKE)){
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void viewPosts(int id){
        connection();
        try (PreparedStatement statement = connec.prepareStatement(VIEW)){
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
