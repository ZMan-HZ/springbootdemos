package com.zzm.applications.jms.listener;

/**
 * <b>Description</b>  JmsConsumerListener
 *
 * @Author Zhenzhen
 * @Since 2020-06-27 周六 12:03
 * @Info JmsConsumerListener
 */


import org.apache.activemq.command.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class JmsConsumerListener {

    private static final Logger logger = LoggerFactory.getLogger(JmsConsumerListener.class);

    private AtomicInteger counter = new AtomicInteger(0);
    private AtomicInteger counter2 = new AtomicInteger(0);

    //@JmsListener(destination = "send") //监听消息, 消息收不全，只能打印处一半，但是MQ里显示全被消费
    public void listen(ActiveMQMessage message) throws JMSException {
        ActiveMQTextMessage textMessage;
        if (message == null) {
            logger.info("Message is nul, class{ " + message.getClass() + "}");
            return;
        }
//            logger.info("Message class{ " + message.getClass() + "}");

        counter.incrementAndGet();
        if (message instanceof ActiveMQTextMessage) {
            textMessage = (ActiveMQTextMessage) message;
            logger.info("Received Text Message: " + textMessage.getText());
        } else if (message instanceof ActiveMQBytesMessage) {
            textMessage = (ActiveMQTextMessage) message;
            logger.info("Bytes Message" + textMessage.getText());
        } else if (message instanceof ActiveMQObjectMessage) {
//            textMessage = ((ActiveMQObjectMessage) message).getObject();
            logger.info("Object Message" + message);
        } else if (message instanceof ActiveMQMapMessage) {
            textMessage = (ActiveMQTextMessage) message.copy();
            logger.info("Bytes Message" + textMessage.getText());
        } else {
            throw new JMSException("Unknown Message type");
        }

        logger.info("counter: " + counter.intValue());
    }

    //@JmsListener(destination = "receive") //监听消息, 消息收不全，只能打印处一半，但是MQ里显示全被消费
    public void receive(ActiveMQMessage message) throws JMSException {
        ActiveMQTextMessage textMessage;
        if (message == null) {
            logger.info("Message is nul, class{ " + message.getClass() + "}");
            return;
        }
//        logger.info("receive:::::::::::::Message class{ " + message.getClass() + "}");
        counter2.incrementAndGet();
        if (message instanceof ActiveMQTextMessage) {
            textMessage = (ActiveMQTextMessage) message;
            logger.info("receive:::::::::::::Received Text Message: " + textMessage.getText());
        } else if (message instanceof ActiveMQBytesMessage) {
            textMessage = (ActiveMQTextMessage) message;
            logger.info("receive:::::::::::::Bytes Message" + textMessage.getText());
        } else if (message instanceof ActiveMQObjectMessage) {
//            textMessage = ((ActiveMQObjectMessage) message).getObject();
            logger.info("receive:::::::::::::Object Message" + message);
        } else if (message instanceof ActiveMQMapMessage) {
            textMessage = (ActiveMQTextMessage) message.copy();
            logger.info("receive:::::::::::::Bytes Message" + textMessage.getText());
        } else {
            throw new JMSException("Unknown Message type");
        }

        logger.info("receive:::::::::::::counter: " + counter2.intValue());
    }


}
