package com.hiep.model;

public class Category {
    private int idCategory;
    private String nameCategory;
    private String status;

    public Category(int idCategory, String nameCategory, String status) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.status = status;
    }

    public Category(int idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
