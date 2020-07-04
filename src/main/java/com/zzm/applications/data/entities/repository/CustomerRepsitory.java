package com.zzm.applications.data.entities.repository;

import com.zzm.applications.data.entities.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b>Description</b>  CustomerRepsitory
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 13:06
 * @Info CustomerRepsitory
 */


//继承Jpa Repository完成对数据库操作。
//在配置文件中进行配置
public interface CustomerRepsitory extends JpaRepository<CustomersEntity,Integer> {
}
