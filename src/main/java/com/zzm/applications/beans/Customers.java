package com.zzm.applications.beans;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>Description</b>  Customers
 *
 * @Author Zhenzhen
 * @Since 2020-06-21 周日 15:47
 * @Info Customers
 */

public class Customers implements Serializable {

    private String id;
    private String name;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String email;
    private String phoneNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedDate;
    private String lastUpdatedBy;
    private CityDistricts cityDistricts;

    public Customers() {
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public String getAddress() {
        return this.address;
    }

    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public CityDistricts getCityDistricts() {
        return this.cityDistricts;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public void setCityDistricts(CityDistricts cityDistricts) {
        this.cityDistricts = cityDistricts;
    }

    @Override
    public String toString() {
        return "Customers(id=" + this.getId() + ", name=" + this.getName() + ", gender=" + this.getGender() + ", birthday=" + this.getBirthday() + ", email=" + this.getEmail() + ", phoneNumber=" + this.getPhoneNumber() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", address=" + this.getAddress() + ", lastUpdatedDate=" + this.getLastUpdatedDate() + ", lastUpdatedBy=" + this.getLastUpdatedBy() + ", cityDistricts=" + this.getCityDistricts() + ")";
    }
}
