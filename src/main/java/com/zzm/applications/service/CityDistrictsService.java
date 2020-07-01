package com.zzm.applications.service;

/**
 * <b>Description</b>  DepartmentService
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 22:07
 * @Info DepartmentService
 */

import com.zzm.applications.beans.CityDistricts;
import com.zzm.applications.service.mapper.CityDistrictsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "cityDistricts")
@Service
public class CityDistrictsService {

    @Autowired(required = false)
    private CityDistrictsMapper cityDistrictsMapper;

//    //此注解只是在不使用cache注解时用
//    @Qualifier("customizedCachManager")//当有多个时，明确指定使用哪一个
//    @Autowired(required = false)
//    private CacheManager customizedCachManager;

    @Cacheable(keyGenerator = "keyGenerator")
    public List<CityDistricts> getAllDisttricts() {
        return cityDistrictsMapper.getAllDisttricts();
    }

    @Cacheable(keyGenerator = "keyGenerator")
    public CityDistricts getDepartmentByZipCode(Integer zipCode) {
        return cityDistrictsMapper.getDisttrictByZipCode(zipCode);
    }

    /**
     * 编码模式进行缓存, 不使用注解时
     */
    /*
    使用缓存管理器获取缓存，进行操作
    public CityDistricts getDepartmentByZipCode1(Integer zipCode) {
        CityDistricts departmentByZipCode = cityDistrictsMapper.getDepartmentByZipCode(zipCode);
        //获取缓存
        Cache cache = customizedCachManager.getCache("department");
        cache.put("depart:1", departmentByZipCode);
        return departmentByZipCode;
    }
    */

}
