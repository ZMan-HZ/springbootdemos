package com.zzm.applications.controller;

import com.zzm.applications.beans.CityDistricts;
import com.zzm.applications.service.CityDistrictsService;
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
public class CityDistrictsController {

@Autowired
private CityDistrictsService cityDistrictsService;

    @GetMapping("/departments")
    public List<CityDistricts> getAllDepartments() {
        return cityDistrictsService.getAllDisttricts();
    }

    @GetMapping("/department/{zipCode}")
    public CityDistricts getDepartmentByZipCode(@PathVariable("zipCode") Integer zipCode) {
        return cityDistrictsService.getDepartmentByZipCode(zipCode);
    }


}
