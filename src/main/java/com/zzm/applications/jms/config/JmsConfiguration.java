package com.zzm.applications.jms.config;

/**
 * <b>Description</b>  JmsConfiguration
 *
 * @Author Zhenzhen
 * @Since 2020-06-27 周六 00:58
 * @Info JmsConfiguration
 */

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.Queue;
import javax.jms.Session;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmsConfiguration {

    private String user;
    private String password;
    private String brokerUrl;

    @Bean
    @ConfigurationProperties(prefix = "spring.activemq")
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        return new ActiveMQConnectionFactory();
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setSessionCacheSize(5);
        cachingConnectionFactory.setReconnectOnException(true);
        cachingConnectionFactory.setTargetConnectionFactory(activeMQConnectionFactory());
        return cachingConnectionFactory;
    }

    //    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        // 定义了typeId到Class的Map
        Map<String, Class<?>> typeIdMap = new HashMap<>();
        typeIdMap.put(Object.class.getName(), Object.class);
        converter.setTypeIdMappings(typeIdMap);
        // 设置发送到队列中的typeId的名称
        converter.setTypeIdPropertyName(Object.class.getName());
        converter.setEncoding("UTF-8");
        return converter;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory());
        jmsTemplate.setReceiveTimeout(1000);
//        jmsTemplate.setMessageConverter(new SimpleMessageConverter()); //默认的converter
        jmsTemplate.setMessageConverter(mappingJackson2MessageConverter());
        jmsTemplate.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        jmsTemplate.setSessionTransacted(false);
        jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }

    @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory listenerContainerFactory = new DefaultJmsListenerContainerFactory();
        listenerContainerFactory.setConnectionFactory(cachingConnectionFactory());
        listenerContainerFactory.setMessageConverter(mappingJackson2MessageConverter());
//        listenerContainerFactory.setPubSubDomain(false);
        listenerContainerFactory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        return listenerContainerFactory;
    }

    //    @Bean("topicListener")
//    public JmsListenerContainerFactory topicJmsListenerContainerFactory(){
//        DefaultJmsListenerContainerFactory listenerContainerFactory = new DefaultJmsListenerContainerFactory();
//        listenerContainerFactory.setConnectionFactory(cachingConnectionFactory());
//        listenerContainerFactory.setMessageConverter(mappingJackson2MessageConverter());
//        listenerContainerFactory.setPubSubDomain(true);
//        listenerContainerFactory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
//        return listenerContainerFactory;
//    }
    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate() {
        JmsMessagingTemplate jmsMessagingTemplate = new JmsMessagingTemplate();
        jmsMessagingTemplate.setConnectionFactory(cachingConnectionFactory());
        jmsMessagingTemplate.setJmsMessageConverter(mappingJackson2MessageConverter());
        return jmsMessagingTemplate;
    }


    @Bean
    public Queue sendQueue() {
        return new ActiveMQQueue("send");
    }

    @Bean
    public Queue receiveQueue() {
        return new ActiveMQQueue("receive");
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrokerUrl() {
        return brokerUrl;
    }

    public void setBrokerUrl(String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }
}
