package com.zzm.applications.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * @Description: This is a JMS Producer
 * @Author: Zhenzhen
 * @Since: 2020-04-11 Saturday 9:44:24 PM
 */

public class JMSProducer {

    private Connection connection;
    private Session session;
    private Queue queue;
    private MessageProducer producer;
    private String user;
    private String ps;

    public JMSProducer() {
        user = "admin";
        ps = "password";
        // int port = Integer.parseInt(env("ACTIVEMQ_PORT", "5672"));
        int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61616"));
        String host = env("ACTIVEMQ_HOST", "localhost");
        String connectionURI = "amqp://" + host + ":" + port;
        String connectiontcp = "tcp://" + host + ":" + port;
        // 1.创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(connectiontcp);
        // ConnectionFactory connectionFactory2 = new MQConnectionFactory();
        // (( MQConnectionFactory)connectionFactory2).setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, true);
        // JmsConnectionFactory connectionFactory = new JmsConnectionFactory(connectionURI);
        // 2.获取连接
        try {
            connection = connectionFactory.createConnection(user, ps);
            // 4.获取session (参数1：是否启动事务,参数2：消息确认模式)
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void publishMessage() {
        try {
            // 3.启动连接
            connection.start();
            // 5.创建队列对象
            queue = session.createQueue("test-queue");
            // 6.创建消息生产者
            producer = session.createProducer(queue);
            // 7.创建消息
            for (int i = 0; i < 10; i++) {
                TextMessage textMessage = session.createTextMessage("Hello, World! ==> " + i);
                // 8.发送消息
                producer.send(textMessage);
                System.out.println("Send message: " + i);
            }
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static String env(String key, String defaultValue) {
        String rc = System.getenv(key);
        if (rc == null) {
            return defaultValue;
        }
        return rc;
    }

    public void closeResource() {
        // 9.关闭资源
        try {
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        JMSProducer producer = new JMSProducer();
        producer.publishMessage();
        producer.closeResource();

    }

}
