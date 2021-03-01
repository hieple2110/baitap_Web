package com.hiep.model;

public class Education {
    private int idEducational;
    private String nameEducational;
    private String status;

    public Education(int idEducational, String nameEducational, String status) {
        this.idEducational = idEducational;
        this.nameEducational = nameEducational;
        this.status = status;
    }

    public Education(int idEducational, String nameEducational) {
        this.idEducational = idEducational;
        this.nameEducational = nameEducational;
    }

    public Education(String nameEducational) {
        this.nameEducational = nameEducational;
    }

    public int getIdEducational() {
        return idEducational;
    }

    public void setIdEducational(int idEducational) {
        this.idEducational = idEducational;
    }

    public String getNameEducational() {
        return nameEducational;
    }

    public void setNameEducational(String nameEducational) {
        this.nameEducational = nameEducational;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Education{" +
                "idEducational=" + idEducational +
                ", nameEducational='" + nameEducational + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
