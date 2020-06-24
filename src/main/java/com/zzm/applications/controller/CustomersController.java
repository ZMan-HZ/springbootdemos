package com.zzm.applications.controller;

import com.zzm.applications.beans.Customers;
import com.zzm.applications.beans.Department;
import com.zzm.applications.dao.CustomerDao;
import com.zzm.applications.dao.DepartmentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * <b>Description</b>  CustomersController
 *
 * @Author Zhenzhen
 * @Since 2020-06-21 周日 15:34
 * @Info CustomersController
 */
@Controller
public class CustomersController {

    private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/customers-list.html")
    public String listCustomer(ModelMap model) {
        Collection<Customers> all = customerDao.getAll();
        model.addAttribute("customers", all);
        return "customers/customers-list";
    }

    @GetMapping("/customers-add.html")
    public String addCustomerPage(ModelMap model) {
        List<Department> allDepartments = departmentDao.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "customers/customers-add";
    }

    @PostMapping("/customers-add.html")
    public String saveCustomer(Customers customer) {
        logger.info("new customer:" + customer);
        customerDao.saveCustomer(customer);
        //redirect: 重定向一个地址  / 表示当前路径
        //forward： 转发到一个地址
        return "redirect:/customers-list.html";
    }

    //重用add页面进行编辑
    @GetMapping("/customers-edit/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap model) {
        Customers customer = customerDao.getCustomer(id);
        model.addAttribute("customer", customer);
        List<Department> allDepartments = departmentDao.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "customers/customers-add";
    }

    //需要手动设置hidden filter在application.properties
    @PutMapping("/customers-add.html")
    public String saveEdit(Customers customer) {
        logger.info("Modified Customer info: " + customer);
        customerDao.saveCustomer(customer);
        return "redirect:/customers-list.html";
    }

//    @DeleteMapping("/customers-delete/{id}")
    @RequestMapping("/customers-delete/{id}")
    public String deleteCustomer(@PathVariable("id") String ids) {
       String[] idArray = StringUtils.delimitedListToStringArray(ids,",");
//        if(ids.contains(",")){
//            idArray = ids.split(",");
//        }else{
//            idArray[0] =ids;
//        }
       for(String id: Arrays.asList(idArray)){
        logger.info("Delete Customer which key=: " + id);
        customerDao.deleteCustomer(Integer.parseInt(id));
       }
        return "redirect:/customers-list.html";
        //redirect 后面必须要加/，不然找不到页面。
    }


}
