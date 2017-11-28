package com.tma.ntnga.musicmanager.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tma.ntnga.musicmanager.entities.Song;
import com.tma.ntnga.musicmanager.messageHandler.JmsTopicSubscriber;
import com.tma.ntnga.musicmanager.messageHandler.JmsTopicSubscriberFactory;
import com.tma.ntnga.musicmanager.messageHandler.MessageConverter;
import com.tma.ntnga.musicmanager.models.MessageStatus;
import com.tma.ntnga.musicmanager.models.MusicManagerMessage;

import javax.jms.*;
import javax.naming.NamingException;

public class Test {
    public static void main(String[] args) throws NamingException, JMSException, JsonProcessingException, InterruptedException {
        JmsTopicSubscriber topicSubscriber = JmsTopicSubscriberFactory.getTopicSubscriberInstance("musicManager");
        Session session = topicSubscriber.getSession();
        Topic topic = topicSubscriber.getTopic();
        MessageProducer publisher = session.createProducer(topic);
        MessageConverter messageConverter = new MessageConverter();
        Song song = new Song(1,"banana","google.com");
        MusicManagerMessage musicManagerMessage =
                new MusicManagerMessage(MessageStatus.CREATED,song);
        TextMessage message = session.createTextMessage(messageConverter.toTextMessage(musicManagerMessage));
        publisher.send(message);
//        while (true){
//           Thread.sleep(10);
//        }
//        session.close();
       // topicSubscriber.getConnection().close();

    }
}
