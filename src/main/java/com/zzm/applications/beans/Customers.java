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
public class Customers  implements Serializable {

    private Integer id;
    private String name;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private String email;
    private String contactNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedDate;
    private String lastUpdatedBy;
    private Department department;

    public Customers() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", department=" + department +
                '}';
    }
}
