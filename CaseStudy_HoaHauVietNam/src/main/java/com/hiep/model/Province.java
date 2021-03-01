package com.hiep.model;

public class Province {
    private int idProvince;
    private String nameProvince;

    private String status;

    public Province(int idProvince, String nameProvince, String status) {
        this.idProvince = idProvince;
        this.nameProvince = nameProvince;
        this.status = status;
    }

    public Province(int idProvince, String nameProvince) {
        this.idProvince = idProvince;
        this.nameProvince = nameProvince;
    }

    public Province(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
