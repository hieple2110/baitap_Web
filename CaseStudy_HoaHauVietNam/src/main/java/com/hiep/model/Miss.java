package com.hiep.model;

import java.sql.Date;

public class Miss {
    private int idMiss;
    private String nameMiss;
    public Date dateOfBirth;
    private String passPort;
    private String address;
    private String job;
    private String email;
    private String numberPhone;
    private int idProvince;
    private int idNation;
    private int idEducational;
    private String image;
    private String status = "Chờ duyệt";
    private Province province;
    private Nation nation;
    private Education education;
    private String isDelete;

    public Miss(int idMiss, String nameMiss, Date dateOfBirth, String passPort, String address, String job, String email, String numberPhone, int idProvince, int idNation, int idEducational, String image, String status,String isDelete) {
        this.idMiss = idMiss;
        this.nameMiss = nameMiss;
        this.dateOfBirth = dateOfBirth;
        this.passPort = passPort;
        this.address = address;
        this.job = job;
        this.email = email;
        this.numberPhone = numberPhone;
        this.idProvince = idProvince;
        this.idNation = idNation;
        this.idEducational = idEducational;
        this.image = image;
        this.status = status;
        this.isDelete = isDelete;
    }



    public Miss(String nameMiss, Date dateOfBirth, String passPort, String address, String job, String email, String numberPhone, int idProvince, int idNation, int idEducational, String image) {
        this.nameMiss = nameMiss;
        this.dateOfBirth = dateOfBirth;
        this.passPort = passPort;
        this.address = address;
        this.job = job;
        this.email = email;
        this.numberPhone = numberPhone;
        this.idProvince = idProvince;
        this.idNation = idNation;
        this.idEducational = idEducational;
        this.image = image;

    }

    public Miss(int idMiss, String nameMiss, Date dateOfBirth, String passPort, String address, String job, String email, String numberPhone, int idProvince, int idNation, int idEducational, String image, String status, Province province, Nation nation, Education education,String isDelete) {
        this.idMiss = idMiss;
        this.nameMiss = nameMiss;
        this.dateOfBirth = dateOfBirth;
        this.passPort = passPort;
        this.address = address;
        this.job = job;
        this.email = email;
        this.numberPhone = numberPhone;
        this.idProvince = idProvince;
        this.idNation = idNation;
        this.idEducational = idEducational;
        this.image = image;
        this.status = status;
        this.province = province;
        this.nation = nation;
        this.education = education;
        this.isDelete = isDelete;
    }

    public Miss(int idMiss, String nameMiss, Date dateOfBirth, String passPort, String address, String job, String email, String numberPhone, int idProvince, int idNation, int idEducational, String image, String status) {
        this.idMiss = idMiss;
        this.nameMiss = nameMiss;
        this.dateOfBirth = dateOfBirth;
        this.passPort = passPort;
        this.address = address;
        this.job = job;
        this.email = email;
        this.numberPhone = numberPhone;
        this.idProvince = idProvince;
        this.idNation = idNation;
        this.idEducational = idEducational;
        this.image = image;
        this.status = status;
    }

    public int getIdMiss() {
        return idMiss;
    }

    public void setIdMiss(int idMiss) {
        this.idMiss = idMiss;
    }

    public String getNameMiss() {
        return nameMiss;
    }

    public void setNameMiss(String nameMiss) {
        this.nameMiss = nameMiss;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassPort() {
        return passPort;
    }

    public void setPassPort(String passPort) {
        this.passPort = passPort;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public int getIdNation() {
        return idNation;
    }

    public void setIdNation(int idNation) {
        this.idNation = idNation;
    }

    public int getIdEducational() {
        return idEducational;
    }

    public void setIdEducational(int idEducational) {
        this.idEducational = idEducational;
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Miss{" +
                "idMiss=" + idMiss +
                ", nameMiss='" + nameMiss + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passPort='" + passPort + '\'' +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", idProvince=" + idProvince +
                ", idNation=" + idNation +
                ", idEducational=" + idEducational +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", province=" + province +
                ", nation=" + nation +
                ", education=" + education +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }
}
