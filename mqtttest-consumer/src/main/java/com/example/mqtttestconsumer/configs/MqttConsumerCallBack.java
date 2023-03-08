package com.example.mqtttestconsumer.configs;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttConsumerCallBack implements MqttCallback {
    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("Da ngat ket noi voi may chu, co the ket noi lai");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println(String.format("Nhan chu de tin nhan : %s",topic));
        System.out.println(String.format("Nhan tin nhan Qos : %d",message.getQos()));
        System.out.println(String.format("Nhan noi dung tin nhan : %s",new String(message.getPayload())));
        System.out.println(String.format("Nhan tin nhan duoc giu lai : %b",message.isRetained()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}