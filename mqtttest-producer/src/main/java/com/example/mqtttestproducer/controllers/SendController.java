package com.example.mqtttestproducer.controllers;

import com.example.mqtttestproducer.configs.MqttProviderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendController {

    @Autowired
    private MqttProviderConfig providerClient;

    @RequestMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(int qos,boolean retained,String topic,String message){
        try {
            providerClient.publish(qos,retained,topic,message);
            return "Gửi thành công";
        }catch (Exception e){
            e.printStackTrace();
            return "Gửi thất bại";
        }
    }
}
