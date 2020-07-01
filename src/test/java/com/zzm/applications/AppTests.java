package com.zzm.applications;

import com.zzm.applications.beans.Customers;
import com.zzm.applications.beans.Person;
import com.zzm.applications.service.mapper.CustomersMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Queue;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppTests {

    private static final Logger logger = LoggerFactory.getLogger(AppTests.class);


    @Autowired
    Person person;

    @Autowired
    ApplicationContext ctx;

    @Autowired
    DataSource dataSource;

//    @Autowired(required = false)
//    private CustomersMapper customersMapper;
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;  //操K/V都是字符串
//
//    @Autowired
//    private StringRedisTemplate stringRedis; //操作K/V都是对象
//
//
//    @Test
//    public void testAppService() {
//        boolean exists = ctx.containsBean("appService");
//        logger.info("appService exist? " + exists);
//    }

//
//    @Test
//    void contextLoads() throws SQLException {
////        logger.info(person.toString());
//        logger.info(String.valueOf(dataSource.getClass()));
//        Connection connection = null;
//        connection = dataSource.getConnection();
//        logger.info(String.valueOf(connection));
//        connection.close();
//    }

    /**
     * Redis 测试
     * Redis 五大常见数据类型
     * String（字符串）， List， Set，Hash，ZSet（有序集合）
     * stringRedis.opsForValue();
     * stringRedis.opsForList();
     * stringRedis.opsForSet();
     * stringRedis.opsForZSet();
     */
//    @Test
//    public void testRedis() {
//        String msgString = null;
//        //给 redis 添加 数据
//        //stringRedis.opsForValue().append("msg","hello,World!");
////       msgString = stringRedis.opsForValue().get("msg");
//        stringRedis.opsForList().leftPush("list", "10");
//        stringRedis.opsForList().leftPush("list", "11");
//        stringRedis.opsForList().leftPush("list", "12");
//
//
//        stringRedis.opsForSet();
//        stringRedis.opsForZSet();
//        logger.info(msgString);
//    }
//
//    @Test
//    public void testRedisWithObject() {
//        Customers customer = customersMapper.getCustomerById(2);
//        //默认如果保存对象，使用jdk的序列化机制，序列化后数据保存到redis中
////        redisTemplate.opsForValue().set("customer-01",customer);//类需要序列化
//        Object object = redisTemplate.opsForValue().get("customer-01");
////        logger.info(object.toString());
//        //1。 将数据以json的形式保存到redis中
//        //配置了序列化类之后，改变默认的序列化规则
//        redisTemplate.opsForValue().set("customerJson", customer);
//
//    }
//
//
//    @Autowired
//    private JmsTemplate jmsTemplate;
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//
//    @Autowired
//    private Queue sendQueue;
//
//    @Autowired
//    private Queue receiveQueue;
//
//
//    @Test
//    public void testSendAndReceive() {
//        String msg = ", test message! ";
////        Customers customer = customersMapper.getCustomerById(2);
//        Customers customer = null;
////        logger.info("Message= " + customer);
//        int counter = 0;
//        String received = null;
//        while (counter < 5) {
//            customer = customersMapper.getCustomerById(counter + 1);
//            jmsTemplate.convertAndSend(receiveQueue, customer);
////            jmsMessagingTemplate.convertAndSend(sendQueue, customer);
////            logger.info(customer.toString());
//            counter++;
//        }
//        logger.info("Message counter= " + counter);
////        while (true) {
////            Object o = jmsTemplate.receiveAndConvert(sendQueue);
////            logger.info(o.getClass().getName());
////            if (o == null) {
////                break;
////            }
////            if (o instanceof byte[]) {
////                received = new String((byte[]) o);
////            } else if (o instanceof String) {
////                received = o.toString();
////            }
////            logger.info(String.valueOf(received));
////        }


//    }


}
