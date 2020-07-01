package com.zzm.applications.service;

/**
 * <b>Description</b>  CustomersServive
 *
 * @Author Zhenzhen
 * @Since 2020-06-26 周五 16:07
 * @Info CustomersServive
 */

import com.zzm.applications.beans.Customers;
import com.zzm.applications.service.mapper.CustomersMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * 可以使用CacheConfig, 设置公共的cache value，key，等等
 */
@CacheConfig(cacheNames = "customers", keyGenerator = "keyGenerator")
@Service
public class CustomersServive {

    private static final Logger logger = LoggerFactory.getLogger(CustomersServive.class);

    @Autowired
    private CustomersMapper customersMapper;

    @Cacheable(keyGenerator = "keyGenerator")
    public List<Customers> getAll() {
        List<Customers> allCustomers = customersMapper.getAllCustomers();
        logger.info(allCustomers.get(1).toString());
        return customersMapper.getAllCustomers();
    }

    @Cacheable
    public Customers getCustomerById(Integer id) {
        Customers customer = customersMapper.getCustomerById(id);
        return customer;
    }

    @CachePut
    public void saveCustomer(Customers customers) {
        customersMapper.saveCustomer(customers);
    }
    @CacheEvict
    public void deleteCustomer(Integer id){
        customersMapper.deleteCustomer(id);
    }
    @CacheEvict
    public void deleteCustomer(List idList){
        customersMapper.deleteCustomerByIdList(idList);
    }

    /**
     * 将结果的运行结果进行缓存，以后相同的数据直接从缓存中取，不再调用方法
     *
     * @param id
     * @return CacgeManager 管理多个组建，对缓存真正CRUD的操作在Cache组件中，每一个缓存组件有自己唯一的名字
     * 几个属性：
     *          cacheName/value： 指定缓存组件的名字
     *          key：缓存数据时用的key，默认使用的是方法参数的值。支持SpEL表达式， 是不能用#result
     *          keyGenerator: @Cacheable(keyGenerator="cacheKeyGenerator")/ 可以注入一个cacheGenerator
     *          key 跟 keyGenerator只能二选一
     *          CacheManager 跟 CacheResolver  只能二选一
     *          condition： 指定符合条件的情况下缓存
     *          unless: 否定缓存， 当unless的指定的条件为true，方法返回值就不缓存，可以获取结果进行判断
     *          sync: 是否使用移步模式， 不支持unless
     *
     *  原理： 自动配置原理 CacheAutoConfiguration。
     *
     *  默认使用是ConcurrentCacheMap，数据保存在concurrentahashmap中
     */

/**
 *  // @CachePut  调用方法，又更新缓存  比如在update的时候。
 *  运行步骤：
 *      直接先调方法，然后把结果放入缓存
 *  测试步骤
 *  1，先缓存一个 数据A
 *  2。然后去update A -> B，
 *  3。再查相同的数据A。
 *  此时, 应该是更新后的吗？  不是。
 *  因为没有更新缓存。cacheable用的key不一样。
 *  解决这个问题：
 *              要同步更新缓存。使用CachePut时，取缓存跟put 缓存使用同样的key
 */

/**
 * // @CahceEvict ： 缓存清除
 *          key： 指定要清除的数据
 *          allEntries = true：  清除缓存中所有的数据
 *          beforeInvocation =false： 缓存的清除是否在方法之前执行，
 *                              默认是在执行之后； 如果出现异常，缓存就不会清除
 *                              如果是true，则是在执行之前清除，无论方法是否存在异常，缓存都会被清除
 */


/**
 * /    /@Caching： 包含了以上三种注解, 可以设置多个缓存key
 *
 * @Caching(
 *  cacheable={@Cacheable(value="",key="")},
 *  put={
 *  @CachePut(value="",key=""
 *  @CachePut(value="",key="")},
 *  )
 */


}
