package com.zzm.applications.jms;



import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer {

	private Connection connection;
	private Session session;
	private Queue queue;
	private MessageConsumer consumer;
	private String user;
	private String ps;

	public JMSConsumer() {
		try {
			user = "admin";
			ps = "password";
//			int port = Integer.parseInt(env("ACTIVEMQ_PORT", "5672"));
			int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61616"));
			String host = env("ACTIVEMQ_HOST", "localhost");
			String connectionURI = "amqp://" + host + ":" + port;
			String connectiontcp = "tcp://" + host + ":" + port;
			// 1.创建连接工厂
			 ConnectionFactory connectionFactory = new  ActiveMQConnectionFactory(connectiontcp);
//			JmsConnectionFactory connectionFactory = new JmsConnectionFactory(connectionURI);
			// 2.获取连接
//			connection = connectionFactory.createConnection();
			connection = connectionFactory.createConnection(user,ps);
			// 3.启动连接
			connection.start();
			// 4.获取session (参数1：是否启动事务,参数2：消息确认模式)
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// 5.创建队列对象
			queue = session.createQueue("test-queue");
			// 6.创建消息消费
			consumer = session.createConsumer(queue);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 7.监听消息
		while(true) {
			try {
				consumer.setMessageListener(new MessageListener() {
					@Override
					public void onMessage(Message message) {
						TextMessage textMessage = (TextMessage) message;
						try {
							System.out.println("接收到消息：" + textMessage.getText());
						} catch (JMSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	// 7.监听消息
	/*
	 * @Override public void onMessage(Message message) { // TODO Auto-generated
	 * method stub try { // 3.启动连接 connection.start(); // 4.获取session
	 * (参数1：是否启动事务,参数2：消息确认模式) session = connection.createSession(false,
	 * Session.AUTO_ACKNOWLEDGE); // 5.创建队列对象 queue =
	 * session.createQueue("test-queue"); // 6.创建消息消费 consumer =
	 * session.createConsumer(queue); TextMessage textMessage = (TextMessage)
	 * message; System.out.println("接收到消息：" + textMessage.getText()); // 8.等待键盘输入
	 * System.in.read(); } catch (JMSException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * }
	 */

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

		JMSConsumer consumer = new JMSConsumer();

		 consumer.closeResource();

	}

}
