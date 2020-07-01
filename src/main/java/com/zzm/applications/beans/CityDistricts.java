package com.zzm.applications.beans;

import java.io.Serializable;

/**
 * <b>Description</b>  CityDistricts
 *
 * @Author Zhenzhen
 * @Since 2020-06-21 周日 18:41
 * @Info CityDistricts
 */
public class CityDistricts implements Serializable {

    private Integer seqID;
    private Integer zipCode;
    private String district;
    private String city;
    private String province;

    public CityDistricts() {
    }

    public CityDistricts(Integer id, Integer zipCode, String district, String city, String province) {
        this.seqID = id;
        this.zipCode = zipCode;
        this.district = district;
        this.city = city;
        this.province = province;
    }

    public Integer getId() {
        return this.seqID;
    }

    public Integer getZipCode() {
        return this.zipCode;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getCity() {
        return this.city;
    }

    public String getProvince() {
        return this.province;
    }

    public void setId(Integer id) {
        this.seqID = id;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "CityDistricts(id=" + this.getId() + ", zipCode=" + this.getZipCode() + ", district=" + this.getDistrict() + ", city=" + this.getCity() + ", province=" + this.getProvince() + ")";
    }


}
