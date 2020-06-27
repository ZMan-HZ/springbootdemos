package com.zzm.applications.jms.bean;

import org.apache.ibatis.annotations.Options;

import java.util.Optional;

/**
 * <b>Description</b>  JmsConfigurProperties  用于MQ的配置信息的bean
 *
 * @Author Zhenzhen
 * @Since 2020-06-27 周六 11:10
 * @Info JmsConfigurProperties
 */


public class JcsConfigProperties {

    private String userName;
    private String password;
    private String brokerUrl;
    private String sendQueueName;
    private String receiveQueueName;
    private String topicName;
    private Boolean isPubSubDomain;
    private Integer maxConnections;
    private Integer receiveTimeout;

    public JcsConfigProperties() {
    }

    public JcsConfigProperties(String userName, String password, String brokerUrl, String sendQueueName, String receiveQueueName, String topicName, Boolean isPubSubDomain, Integer maxConnections, Integer receiveTimeout) {
        this.userName = userName;
        this.password = password;
        this.brokerUrl = brokerUrl;
        this.sendQueueName = sendQueueName;
        this.receiveQueueName = receiveQueueName;
        this.topicName = Optional.ofNullable(topicName).orElse(null);
        this.isPubSubDomain = Optional.ofNullable(isPubSubDomain).orElse(false);
        this.maxConnections = Optional.ofNullable(maxConnections).orElse(10);
        this.receiveTimeout = Optional.ofNullable(receiveTimeout).orElse(1000);
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getBrokerUrl() {
        return this.brokerUrl;
    }

    public String getSendQueueName() {
        return this.sendQueueName;
    }

    public String getReceiveQueueName() {
        return this.receiveQueueName;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public Boolean getIsPubSubDomain() {
        return this.isPubSubDomain;
    }

    public Integer getMaxConnections() {
        return this.maxConnections;
    }

    public Integer getReceiveTimeout() {
        return this.receiveTimeout;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBrokerUrl(String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    public void setSendQueueName(String sendQueueName) {
        this.sendQueueName = sendQueueName;
    }

    public void setReceiveQueueName(String receiveQueueName) {
        this.receiveQueueName = receiveQueueName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setIsPubSubDomain(Boolean isPubSubDomain) {
        this.isPubSubDomain = isPubSubDomain;
    }

    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void setReceiveTimeout(Integer receiveTimeout) {
        this.receiveTimeout = receiveTimeout;
    }

    @Override
    public String toString() {
        return "JcsConfigProperties(userName=" + this.getUserName() + ", password=" + this.getPassword() + ", brokerUrl=" + this.getBrokerUrl() + ", sendQueueName=" + this.getSendQueueName() + ", receiveQueueName=" + this.getReceiveQueueName() + ", topicName=" + this.getTopicName() + ", isPubSubDomain=" + this.getIsPubSubDomain() + ", maxConnections=" + this.getMaxConnections() + ", receiveTimeout=" + this.getReceiveTimeout() + ")";
    }
}
