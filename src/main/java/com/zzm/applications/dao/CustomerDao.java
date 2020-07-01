package com.zzm.applications.dao;

/**
 * <b>Description</b>  CustomerDao
 *
 * @Author Zhenzhen
 * @Since 2020-06-21 周日 15:46
 * @Info CustomerDao
 */

import com.zzm.applications.beans.Customers;
import com.zzm.applications.beans.CityDistricts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerDao {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDao.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Map<String, Object> getAllDBCustomer() {
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("SELECT * FROM CUSTOMERS_LIST");
//        Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM CUSTOMERS_LIST"); //返回是一行
//        for (Map.Entry entry : map.entrySet()) {
//            logger.info("key=" + entry.getKey() + ", value= " + entry.getValue());
//        }
//        for (Map<String, Object> customerMap : mapList) {
//        }
        return mapList.get(0);
    }

    private static Map<Integer, Customers> customersMap = null;

    static {
        customersMap = new HashMap<>();
        customersMap.put(1, new Customers());
        customersMap.put(2, new Customers());
        customersMap.put(3, new Customers());
        customersMap.put(4, new Customers());
        customersMap.put(5, new Customers());
        customersMap.put(6, new Customers());
        customersMap.put(7, new Customers());
        customersMap.put(8, new Customers());
        customersMap.put(9, new Customers());
        customersMap.put(10, new Customers());
    }

    public Collection<Customers> getAll() {

        return customersMap.values();
    }

    public void saveCustomer(Customers customers) {
        CityDistricts department = customers.getDepartment();
        if (customers.getId() == null) {
            customers.setId(String.valueOf(customersMap.size() + 1));
        }

//        customers.setId(11);
//        switch (department.getZipCode()) {
//            case 1:
//                department.setAddress("SanDun");
//                break;
//            case 2:
//                department.setAddress("Xihu");
//                break;
//            case 3:
//                department.setAddress("XiaCheng");
//                break;
//            default:
//                break;
//        }
        customers.setDepartment(department);
        customersMap.put(Integer.parseInt(customers.getId()), customers);
    }

    public Customers getCustomer(Integer id) {

//        for (Map.Entry<Integer, Customers> entry : customersMap.entrySet()) {
//            Integer key = entry.getKey();
//            String idx = entry.getValue().getId();
//            if (id.equals(idx)) {
//                return entry.getValue();
//            }
//        }
        return null;
    }

    public void deleteCustomer(Integer id) {
        customersMap.remove(id);
    }


}
