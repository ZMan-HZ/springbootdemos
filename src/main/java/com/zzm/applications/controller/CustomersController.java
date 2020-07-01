package com.zzm.applications.controller;

import com.zzm.applications.beans.CityDistricts;
import com.zzm.applications.beans.Customers;
import com.zzm.applications.service.CustomersServive;
import com.zzm.applications.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
public class CustomersController {

    private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);

    //移除Dao的Autowired，改用service直接调用Mapper
    @Autowired
    private CustomersServive customersServive;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/customers-list.html")
    public String listCustomer(ModelMap model) {
        Collection<Customers> all = customersServive.getAll();
        model.addAttribute("customers", all);

        return "customers/customers-list";
    }
    @ResponseBody
    @GetMapping("/customers/list")
    public Collection<Customers> reactListCustomer() {
        Collection<Customers> all = customersServive.getAll();
        logger.info("@@@@@@@@@@@@@@@@@@@@@react call..");
        return all;
    }

    @GetMapping("/customers-add.html")
    public String addCustomerPage(ModelMap model) {
        List<CityDistricts> allDepartments = departmentService.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "customers/customers-add";
    }

    @PostMapping("/customers-add.html")
    public String saveCustomer(Customers customer) {
        logger.info("new customer:" + customer);
        customersServive.saveCustomer(customer);
        //redirect: 重定向一个地址  / 表示当前路径
        //forward： 转发到一个地址
        return "redirect:/customers-list.html";
    }

    //重用add页面进行编辑
    @GetMapping("/customers-edit/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap model) {
        Customers customer = customersServive.getCustomerById(id);
        model.addAttribute("customer", customer);
        List<CityDistricts> allDepartments = departmentService.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "customers/customers-add";
    }

    //需要手动设置hidden filter在application.properties
    @PutMapping("/customers-add.html")
    public String saveEdit(Customers customer) {
        logger.info("Modified Customer info: " + customer);
        customersServive.saveCustomer(customer);
        return "redirect:/customers-list.html";
    }

    //    @DeleteMapping("/customers-delete/{id}")
    @RequestMapping("/customers-delete/{id}")
    public String deleteCustomer(@PathVariable("id") String ids) {
        String[] idArray = StringUtils.delimitedListToStringArray(ids, ",");
        for (String id : idArray) {
            logger.info("Delete Customer which key=: " + id);
            customersServive.deleteCustomer(Integer.parseInt(id));
        }
        return "redirect:/customers-list.html";
        //redirect 后面必须要加/，不然找不到页面。
    }
//    @ResponseBody
//    @GetMapping("/customers-list/{id}")
//    public Customers getCustomerById(@PathVariable("id") Integer id) {
//        Customers customers = customersServive.getCustomerById(id);
//        logger.info(String.valueOf(customers));
//        return customers;
//    }


}
