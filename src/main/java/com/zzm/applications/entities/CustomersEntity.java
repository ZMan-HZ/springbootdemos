package com.zzm.applications.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zzm.applications.beans.Department;

import javax.persistence.*;
import java.util.Date;

/**
 * <b>Description</b>  CustomersEntity 使用JPA 注解映射关系，此包中的类是在结合JPA
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 12:55
 * @Info CustomersEntity
 */

@Entity //告诉JPA，这是一个实体类（和数据表的映射类），非一般的JavaBean
@Table(name = "CUSTOMERS_LIST_JPA") //@Table 来指定和哪个表对应；如果省略，表面就是类名的小写
public class CustomersEntity {

    //属性copy于 Customers Bean
    @Id //这是主键
//    @SequenceGenerator(name = "devicegroup_gid_seq", allocationSize = 1, initialValue = 1, sequenceName = "devicegroup_gid_seq")
//    @GeneratedValue(generator = "devicegroup_gid_seq", strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键. 此方法报错，可能是由于数据库不同
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="name",length = 30) //和数据表的对应的一个列
    private String name;
    @Column   //省略，默认column name跟属性名一致
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date birthday;
    @Column
    private String email;
    @Column
    private String contactNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date endDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date lastUpdatedDate;
    @Column
    private String lastUpdatedBy;
//    @Column(name = "{ZIP_CODE,DISTRICT}")
//    private Department department;


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

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
}
