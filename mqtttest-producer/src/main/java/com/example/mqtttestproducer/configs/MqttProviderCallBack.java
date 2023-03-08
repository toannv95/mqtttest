package com.example.mqtttestproducer.configs;

import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttProviderCallBack implements MqttCallback {

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println(clientId + "Mat ket noi voi may chu");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        IMqttAsyncClient client = iMqttDeliveryToken.getClient();
        System.out.println(client.getClientId() + "Gui tin nhan thanh cong！");
    }
}
