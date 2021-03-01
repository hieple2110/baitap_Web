package com.hiep.model;

public class Posts {
    private  int idPosts;
    private String image;
    private String title;
    private String shortContent;
    private String fullContent;
    private String status;

    public Posts(int idPosts, String image, String title, String shortContent, String fullContent, String status) {
        this.idPosts = idPosts;
        this.image = image;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.status = status;
    }

    public Posts(int idPosts, String image, String title, String shortContent, String fullContent) {
        this.idPosts = idPosts;
        this.image = image;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
    }

    public Posts(String image, String title, String shortContent, String fullContent) {
        this.image = image;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
    }

    public int getIdPosts() {
        return idPosts;
    }

    public void setIdPosts(int idPosts) {
        this.idPosts = idPosts;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
