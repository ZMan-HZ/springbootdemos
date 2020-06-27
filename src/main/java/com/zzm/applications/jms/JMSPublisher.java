package com.zzm.applications.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSPublisher {

	private Connection connection;
	private Session session;
	private MessageProducer producer;
	private Topic topic;
	private String user;
	private String ps;

	public JMSPublisher() {
		user = "admin";
		ps = "password";
		// int port = Integer.parseInt(env("ACTIVEMQ_PORT", "5672"));
		int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61616"));
		String host = env("ACTIVEMQ_HOST", "localhost");
		String connectionURI = "amqp://" + host + ":" + port;
		String connectiontcp = "tcp://" + host + ":" + port;
		try {
			// 1.创建连接工厂
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(connectiontcp);
			// 2.获取连接
			connection = connectionFactory.createConnection();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void publish() {
		// 3.启动连接
		try {
			connection.start();
			// 4.获取session (参数1：是否启动事务,参数2：消息确认模式)
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// 5.创建主题对象
			topic = session.createTopic("test-topic");
			// 6.创建消息生产者
			producer = session.createProducer(topic);
			for (int i = 0; i < 50; i++) {
				// 7.创建消息
				TextMessage textMessage = session.createTextMessage("欢迎来到 ActiveMQ 世界 -->" + i);
				// 8.发送消息
				producer.send(textMessage);
				//Thread.sleep(3 * 1000);
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

		JMSPublisher producer = new JMSPublisher();
		producer.publish();
		producer.closeResource();

	}

}
