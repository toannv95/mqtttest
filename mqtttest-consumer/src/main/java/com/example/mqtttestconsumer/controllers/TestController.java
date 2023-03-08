package com.example.mqtttestconsumer.controllers;

import com.example.mqtttestconsumer.configs.MqttConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private MqttConsumerConfig client;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @RequestMapping("connect")
    @ResponseBody
    public String connect(){
        client.connect();
        return clientId + "Ket noi thanh cong voi may chu";
    }

    @RequestMapping("disConnect")
    @ResponseBody
    public String disConnect(){
        client.disConnect();
        return clientId + "Ngat ket noi voi may chu";
    }
}
