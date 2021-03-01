package com.hiep.model;

public class Nation {
    private int idNation;
    private String nameNation;
    private String status;

    public Nation(int idNation, String nameNation, String status) {
        this.idNation = idNation;
        this.nameNation = nameNation;
        this.status = status;
    }

    public Nation(int idNation, String nameNation) {
        this.idNation = idNation;
        this.nameNation = nameNation;
    }

    public Nation(String nameNation) {
        this.nameNation = nameNation;
    }

    public int getIdNation() {
        return idNation;
    }

    public void setIdNation(int idNation) {
        this.idNation = idNation;
    }

    public String getNameNation() {
        return nameNation;
    }

    public void setNameNation(String nameNation) {
        this.nameNation = nameNation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
