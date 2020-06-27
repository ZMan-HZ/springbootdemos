package com.zzm.applications.service.mapper;

/**
 * <b>Description</b>  CustomersMapper
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 08:59
 * @Info CustomersMapper
 */


import com.zzm.applications.beans.Customers;

//@Mapper //此处已被com.zzm.applications.config.CustomizedMyBatisConfiguration 的 mapper scan代替
public interface JmsConfigMapper {

    public Customers getCustomerById(Integer id);

}
