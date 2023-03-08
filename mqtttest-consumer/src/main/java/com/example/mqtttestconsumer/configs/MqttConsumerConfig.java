package com.example.mqtttestconsumer.configs;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MqttConsumerConfig {
    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.password}")
    private String password;

    @Value("${spring.mqtt.url}")
    private String hostUrl;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;

    private MqttClient client;

    @PostConstruct
    public void init(){
        connect();
    }

    public void connect(){
        try {
            client = new MqttClient(hostUrl,clientId,new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            options.setConnectionTimeout(100);
            options.setKeepAliveInterval(20);
            //options.setWill("willTopic",(clientId + "Ngat ket noi voi may chu").getBytes(),0,false);
            client.setCallback(new MqttConsumerCallBack());
            client.connect(options);
            int[] qos = {1,1};
            String[] topics = {"topic1","topic2"};
            client.subscribe(topics,qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void disConnect(){
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(String topic,int qos){
        try {
            client.subscribe(topic,qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
