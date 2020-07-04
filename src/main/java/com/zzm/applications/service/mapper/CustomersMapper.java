package com.zzm.applications.service.mapper;

/**
 * <b>Description</b>  CustomersMapper
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 08:59
 * @Info CustomersMapper
 */


import com.zzm.applications.mvc.beans.Customers;

import java.util.List;

//@Mapper //此处已被com.zzm.applications.config.CustomizedMyBatisConfiguration 的 mapper scan代替
public interface CustomersMapper {

    public List<Customers> getAllCustomers();
    public Customers getCustomerById(Integer id);
    public Customers saveCustomer(Customers customers);
    public void deleteCustomer(Integer id);
    public void deleteCustomerByIdList(List idLists);

}
