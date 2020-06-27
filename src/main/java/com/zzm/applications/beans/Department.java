package com.zzm.applications.beans;

import java.io.Serializable;

/**
 * <b>Description</b>  Department
 *
 * @Author Zhenzhen
 * @Since 2020-06-21 周日 18:41
 * @Info Department
 */
public class Department  implements Serializable {

    private Integer zipCode;
    private String district;
    private String address;
    private String city;

    public Department() {
    }

    public Department(String district, String address, String city, Integer zipCode) {
        this.zipCode = zipCode;
        this.district = district;
        this.address = address;
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Department{" +
                "zipCode=" + zipCode +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
