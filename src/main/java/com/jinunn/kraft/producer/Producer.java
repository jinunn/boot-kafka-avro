package com.jinunn.kraft.producer;

import com.jinunn.kraft.avro.User;
import com.jinunn.kraft.consumer.AvroConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jin-Dun
 * @date 2023/6/20 16:20
 */
@RestController
@RequestMapping("/send")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class Producer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    @GetMapping("/test")
    public void sendMsg() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("张" + i);
            user.setAge(35 + i);
            kafkaTemplate.send(AvroConsumer.TOPIC_NAME, user);
        }
    }
}
