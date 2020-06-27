package com.zzm.applications.service.mapper;

/**
 * <b>Description</b>  DepartmentMapper
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 09:00
 * @Info DepartmentMapper
 */

import com.zzm.applications.beans.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentMapper {

    public List<Department> getAllDepartments();

    public Department getDepartmentByZipCode(Integer zipCode);

    public void deleteDepartment(Integer zip_code);

    public void insertDepartment(Department department);

    public int updateDepartment(Department department);

}
