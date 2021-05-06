package com.hiep.model;

import java.time.LocalDateTime;

public class Comment {
    private int idComment;
    private String content;
    private LocalDateTime dateComment;
    private  int idPosts;
    private int idAccount;
    private String image;
    private String userName;
    private Posts posts;
    private Account account;
    private String status;

    public Comment(int idComment, String content, LocalDateTime dateComment, int idPosts,int idAccount,String image, String userName,String status) {
        this.idComment = idComment;
        this.content = content;
        this.dateComment = dateComment;
        this.idPosts = idPosts;
        this.idAccount = idAccount;
        this.image = image;
        this.userName = userName;
        this.status = status;
    }


    public Comment(String content, int idPosts, int idAccount, String image, String userName) {
        this.content = content;
        this.idPosts = idPosts;
        this.idAccount = idAccount;
        this.image = image;
        this.userName = userName;
    }

    public Comment(int idComment, String content, LocalDateTime dateComment, Posts posts, Account account) {
        this.idComment = idComment;
        this.content = content;
        this.dateComment = dateComment;
        this.posts = posts;
        this.account = account;
    }

    public Comment(String content, LocalDateTime dateComment,Account account) {
        this.content = content;
        this.dateComment = dateComment;
        this.account = account;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateComment() {
        return dateComment;
    }

    public void setDateComment(LocalDateTime dateComment) {
        this.dateComment = dateComment;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdPosts() {
        return idPosts;
    }

    public void setIdPosts(int idPosts) {
        this.idPosts = idPosts;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
}
