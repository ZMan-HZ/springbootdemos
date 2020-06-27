package com.zzm.applications.controller;

import com.zzm.applications.beans.Department;
import com.zzm.applications.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>Description</b>  DepartmentConntroller
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 09:20
 * @Info DepartmentConntroller
 */


@RestController
public class DepartmentController {

@Autowired
private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/department/{zipCode}")
    public Department getDepartmentByZipCode(@PathVariable("zipCode") Integer zipCode) {
        return departmentService.getDepartmentByZipCode(zipCode);
    }


}
