package com.personal.learning.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

  Logger logger =  LoggerFactory.getLogger(KafkaMessageListener.class);

  @KafkaListener(topics = "topic-test-1", groupId = "learn-group-1")
  public void consume(String message){
      logger.info("consumer consumed the message {}" , message);

  }

}
