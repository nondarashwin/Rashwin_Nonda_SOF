package com.manipal.mail.kafka

import com.manipal.mail.mail.SendMail
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {
    @KafkaListener(topics = ["pipe"], groupId = "anything")
    fun consumer(messages: String) {
        val sendMail = SendMail()
        println("Info Received$messages")

    }
}