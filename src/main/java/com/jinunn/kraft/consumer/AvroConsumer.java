package com.jinunn.kraft.consumer;

import com.jinunn.kraft.avro.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author Jin-Dun
 * @date 2023/6/20 16:15
 */
@Slf4j
@Component
public class AvroConsumer {

    public static final String TOPIC_NAME = "test";

    @KafkaListener(topics = TOPIC_NAME, groupId = "test-group")
    public void consume(ConsumerRecord<String, User> record, Acknowledgment ack) {
        log.info("value #=>:{}", record.value());
        // 手动提交ack
        ack.acknowledge();
    }
}
