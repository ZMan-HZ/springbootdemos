package com.zzm.applications.service.mapper;

/**
 * <b>Description</b>  CityDistrictsMapper
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 09:00
 * @Info CityDistrictsMapper
 */

import com.zzm.applications.beans.CityDistricts;

import java.util.List;

public interface CityDistrictsMapper {

    public List<CityDistricts> getAllDepartments();

    public CityDistricts getDepartmentByZipCode(Integer zipCode);

    public void deleteDepartment(Integer zip_code);

    public void insertDepartment(CityDistricts department);

    public int updateDepartment(CityDistricts department);

}
