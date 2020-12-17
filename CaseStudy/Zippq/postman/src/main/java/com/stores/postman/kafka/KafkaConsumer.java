package com.stores.postman.kafka;


import com.stores.postman.mail.SendMail;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "mails",groupId = "anything")
    public void consumer(String messages){
        SendMail sendMail=new SendMail();
        System.out.println("Info Received"+messages);
        String[] message=messages.split(",",3);
        if(message.length==3){
            sendMail.sendMail(message[0],message[1],message[2]);
            System.out.println("Mail Sent");
        }
    }
}
