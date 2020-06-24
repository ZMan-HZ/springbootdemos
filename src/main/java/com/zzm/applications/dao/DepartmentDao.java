package com.zzm.applications.dao;

import com.zzm.applications.beans.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Description</b>  DepartmentDao
 *
 * @Author Zhenzhen
 * @Since 2020-06-21 周日 21:33
 * @Info DepartmentDao
 */

@Repository
public class DepartmentDao {

    private static List<Department> departmentList;

    static {
        departmentList = new ArrayList<>();
        departmentList.add(new Department("SanDun", "HZ", 1));
        departmentList.add(new Department("Xihu", "HZ", 2));
        departmentList.add(new Department("Xiacheng", "HZ", 3));
    }

    public List<Department> getAllDepartments() {
        return departmentList;
    }


}
