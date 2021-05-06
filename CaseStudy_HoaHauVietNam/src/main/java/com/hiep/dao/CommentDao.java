package com.hiep.dao;

import com.hiep.model.Account;
import com.hiep.model.Comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommentDao extends DaoHelper implements BaseDao<Comment> {
    public static final String INSERT_COMMENT = "INSERT INTO comment ( content , idPosts , idAccount,image,userName )VALUES(?,?,?,?,?)";
    private final String SELECT_COMMENT_IN_POST = " select comment.*, account.image from comment " +
            "inner join account on comment.idAccount = account.idAccount " +
            "inner join posts on comment.idPosts = posts.idPosts and posts.idPosts = ?;";
    public static final String LIST_COMMENT = "select comment.*, account.image, account.userName from comment inner join account on comment.idAccount = account.idAccount";

    @Override
    public List<Comment> getAll() throws SQLException {
        List<Comment> listComment = new ArrayList<>();
        connection();
        try (PreparedStatement statement = connec.prepareStatement(LIST_COMMENT)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idComment = rs.getInt("idComment");
                String content = rs.getString("content");
                String date = rs.getString("dateComment");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(date, dateTimeFormatter);
                int idPosts = rs.getInt("idPosts");
                int idAccount = rs.getInt("idAccount");
                String image = rs.getString("image");
                String userName = rs.getString("userName");
                String status = rs.getString("status");
                Comment comment = new Comment(idComment, content, dateTime, idPosts, idAccount, image, userName, status);
                listComment.add(comment);
            }
            disconnection();
            return listComment;
        }
    }


    @Override
    public void insert(Comment comment) throws SQLException {
        connection();
        try (PreparedStatement statement = connec.prepareStatement(INSERT_COMMENT)){
            statement.setString(1,comment.getContent());
            statement.setInt(2,comment.getIdPosts());
            statement.setInt(3,comment.getIdAccount());
            statement.setString(4,comment.getImage());
            statement.setString(5,comment.getUserName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(int id, Comment comment) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Comment findById(int id) throws SQLException {
        return null;
    }

    public List<Comment> selectCommentsInPost(int id) throws SQLException {
        List<Comment> commentList = new ArrayList<>();
        connection();
        try (
                PreparedStatement statement = connec.prepareStatement(SELECT_COMMENT_IN_POST);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
//                idComment, content, dateComment, idPosts, idAccount, image, userName, status, image
                String imageAccount = rs.getString("image");
                String userName = rs.getString("userName");
                String content = rs.getString("content");
//                java.util.Date d = rs.getTimestamp("dateComment")
                String date = rs.getString("dateComment");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(date, dateTimeFormatter);
                Account account = new Account(imageAccount, userName);
                Comment comment = new Comment(content, dateTime, account);

                commentList.add(comment);
            }
        }
        return commentList;
    }
}
