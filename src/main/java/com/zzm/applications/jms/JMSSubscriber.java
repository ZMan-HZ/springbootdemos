package com.zzm.applications.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSSubscriber {

	private Connection connection;
	private Session session;
	private MessageConsumer consumer;
	private Topic topic;
	private String user;
	private String ps;

	public JMSSubscriber() {
		user = "admin";
		ps = "password";
		int port1 = Integer.parseInt(env("ACTIVEMQ_PORT", "5672"));
		int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61616"));
		String host = env("ACTIVEMQ_HOST", "localhost");
		String connectionURI = "amqp://" + host + ":" + port1;
		String connectiontcp = "tcp://" + host + ":" + port;
		// 1.创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(connectiontcp);
		// JmsConnectionFactory connectionFactory = new
		// JmsConnectionFactory(connectionURI);
		// 2.获取连接
		try {
			// connection = connectionFactory.createConnection();
			connection = connectionFactory.createConnection(user, ps);
			// 3.启动连接
			connection.start();
			// 4.获取session (参数1：是否启动事务,参数2：消息确认模式)
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// 5.创建主题对象
			// Queue queue = session.createQueue("test-queue");
			topic = session.createTopic("test-topic");
			// 6.创建消息消费
			consumer = session.createConsumer(topic);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 7.监听消息
		while (true) {
			/* option 1
			 * try { consumer.setMessageListener(new MessageListener() { public void
			 * onMessage(Message message) { TextMessage textMessage = (TextMessage) message;
			 * try { System.out.println("Receive：" + textMessage.getText()); } catch
			 * (JMSException e) { // TODO Auto-generated catch block e.printStackTrace(); }
			 * } }); } catch (JMSException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

			// * option 2
			try {
				Message msg = consumer.receive();
				System.out.println("Receive：" + ((TextMessage) msg).getText());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
			consumer.close();
			session.close();
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		JMSSubscriber consumer = new JMSSubscriber();

		consumer.closeResource();

	}

}
