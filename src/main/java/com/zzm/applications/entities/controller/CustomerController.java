package com.zzm.applications.entities.controller;

import com.zzm.applications.entities.CustomersEntity;
import com.zzm.applications.entities.repository.CustomerRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * <b>Description</b>  CustomerController
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 13:13
 * @Info CustomerController
 */


@RestController
public class CustomerController {


    @Autowired
    private CustomerRepsitory customerRepsitory;


    @GetMapping("/entity/{id}")
    public Optional<CustomersEntity> getCustomerEntityByID(@PathVariable("id") Integer id) {
        Optional<CustomersEntity> entity = customerRepsitory.findById(id);
        return entity;
    }

    @GetMapping("/entity")
    public CustomersEntity insertEntity(CustomersEntity entity){
        CustomersEntity save = customerRepsitory.save(entity);
        return save;
    }
}
