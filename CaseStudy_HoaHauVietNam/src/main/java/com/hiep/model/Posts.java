package com.hiep.model;

import java.time.LocalDateTime;

public class Posts {
    private  int idPosts;
    private String image;
    private String title;
    private String shortContent;
    private String fullContent;
    private LocalDateTime date;
    private  int idCategory;
    private Category category;
    private String status;
    private  int like;
    private  int view;


    public Posts(int idPosts, String image, String title, String shortContent, String fullContent, LocalDateTime date, int idCategory, Category category, String status,int like,int view) {
        this.idPosts = idPosts;
        this.image = image;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.date = date;
        this.idCategory = idCategory;
        this.category = category;
        this.status = status;
        this.like = like;
        this.view = view;
    }

    public Posts(String image, String title, String shortContent, String fullContent, int idCategory) {
        this.image = image;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.idCategory = idCategory;

    }

    public Posts(int idPosts, String image, String title, String shortContent, String fullContent, int idCategory) {
        this.idPosts = idPosts;
        this.image = image;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.idCategory = idCategory;

    }

    public int getIdPosts() {
        return idPosts;
    }

    public void setIdPosts(int idPosts) {
        this.idPosts = idPosts;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
