package com.zzm.applications.dao;

/**
 * <b>Description</b>  CustomerDao
 *
 * @Author Zhenzhen
 * @Since 2020-06-21 周日 15:46
 * @Info CustomerDao
 */

import com.zzm.applications.beans.Customers;
import com.zzm.applications.beans.Department;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerDao {

    private static Map<Integer, Customers> customersMap = null;

    static {
        customersMap = new HashMap<>();
        customersMap.put(1, new Customers(1, "Lisa", "lisa@qq.com", "M", new GregorianCalendar(1992, Calendar.SEPTEMBER, 17).getTime(), new Department("SanDun", "HZ", 1)));
        customersMap.put(2, new Customers(2, "Alex", "Alex@qq.com", "F", new GregorianCalendar(1993, Calendar.NOVEMBER, 18).getTime(), new Department("Xihu", "HZ", 2)));
        customersMap.put(3, new Customers(3, "Bob", "lisa@qq.com", "F", new GregorianCalendar(1994, Calendar.OCTOBER, 19).getTime(), new Department("XiaCheng", "HZ", 3)));
        customersMap.put(4, new Customers(4, "Carly", "Carly@qq.com", "M", new GregorianCalendar(1995, Calendar.JULY, 16).getTime(), new Department("SanDun", "HZ", 1)));
        customersMap.put(5, new Customers(5, "Daphna", "Daphna@qq.com", "M", new GregorianCalendar(1996, Calendar.JUNE, 15).getTime(), new Department("Xihu", "HZ", 2)));
        customersMap.put(6, new Customers(6, "Eric", "Eric@qq.com", "F", new GregorianCalendar(1997, Calendar.MAY, 17).getTime(), new Department("XiaCheng", "HZ", 3)));
        customersMap.put(7, new Customers(7, "Frank", "Frank@qq.com", "M", new GregorianCalendar(1998, Calendar.APRIL, 13).getTime(), new Department("SanDun", "HZ", 1)));
        customersMap.put(8, new Customers(8, "Graced", "Graced@qq.com", "M", new GregorianCalendar(1999, Calendar.JANUARY, 17).getTime(), new Department("Xihu", "HZ", 2)));
        customersMap.put(9, new Customers(9, "Hank", "Hank@qq.com", "F", new GregorianCalendar(1991, Calendar.FEBRUARY, 16).getTime(), new Department("XiaCheng", "HZ", 3)));
        customersMap.put(10, new Customers(10, "Iris", "Iris@qq.com", "M", new GregorianCalendar(1990, Calendar.AUGUST, 17).getTime(), new Department("Xihu", "HZ", 2)));
    }

    public Collection<Customers> getAll() {

        return customersMap.values();
    }

    public void saveCustomer(Customers customers) {
        Department department = customers.getDepartment();
        if (customers.getId() == null) {
            customers.setId(customersMap.size() + 1);
        }

//        customers.setId(11);
        switch (department.getId()) {
            case 1:
                department.setAddress("SanDun");
                break;
            case 2:
                department.setAddress("Xihu");
                break;
            case 3:
                department.setAddress("XiaCheng");
                break;
            default:
                break;
        }
        customers.setDepartment(department);
        customersMap.put(customers.getId(), customers);
    }

    public Customers getCustomer(Integer id) {

        for (Map.Entry<Integer, Customers> entry : customersMap.entrySet()) {
            Integer key = entry.getKey();
            Integer idx = entry.getValue().getId();
            if (id.equals(idx)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void deleteCustomer(Integer id) {
        customersMap.remove(id);
    }


}
