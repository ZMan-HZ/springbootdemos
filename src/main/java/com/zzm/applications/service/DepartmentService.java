package com.zzm.applications.service;

/**
 * <b>Description</b>  DepartmentService
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 22:07
 * @Info DepartmentService
 */

import com.zzm.applications.beans.Department;
import com.zzm.applications.service.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "department")
@Service
public class DepartmentService {

    @Autowired(required = false)
    private DepartmentMapper departmentMapper;

//    //此注解只是在不使用cache注解时用
//    @Qualifier("customizedCachManager")//当有多个时，明确指定使用哪一个
//    @Autowired(required = false)
//    private CacheManager customizedCachManager;

    @Cacheable(keyGenerator = "keyGenerator")
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments();
    }

    @Cacheable(keyGenerator = "keyGenerator")
    public Department getDepartmentByZipCode(Integer zipCode) {
        return departmentMapper.getDepartmentByZipCode(zipCode);
    }

    /**
     * 编码模式进行缓存, 不使用注解时
     */
    /*
    使用缓存管理器获取缓存，进行操作
    public Department getDepartmentByZipCode1(Integer zipCode) {
        Department departmentByZipCode = departmentMapper.getDepartmentByZipCode(zipCode);
        //获取缓存
        Cache cache = customizedCachManager.getCache("department");
        cache.put("depart:1", departmentByZipCode);
        return departmentByZipCode;
    }
    */

}
