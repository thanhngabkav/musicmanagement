package com.tma.ntnga.musicmanager.services;

import com.tma.ntnga.musicmanager.messageHandler.JmsTopicSubscriber;
import com.tma.ntnga.musicmanager.messageHandler.JmsTopicSubscriberFactory;
import com.tma.ntnga.musicmanager.messageHandler.MessageConverter;
import com.tma.ntnga.musicmanager.models.MusicManagerMessage;

import javax.jms.*;
import javax.naming.NamingException;
import java.io.IOException;

public class TestReceiver {
    public static void main(String[] args) throws NamingException, JMSException {
        JmsTopicSubscriber topicSubscriber = JmsTopicSubscriberFactory.getTopicSubscriberInstance("musicManager");
        Session session = topicSubscriber.getSession();
        Topic topic = topicSubscriber.getTopic();
        MessageConsumer messageConsumer = session.createConsumer(topic);
        while (true) {
            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    MessageConverter messageConverter = new MessageConverter();
                    MusicManagerMessage musicManagerMessage = new MusicManagerMessage();
                    try {
                        musicManagerMessage = messageConverter.toMusicManagerMessage(textMessage.getText());
                        System.out.println("========== Message =========== :"+musicManagerMessage.toString());
                    } catch (IOException e) {

                        e.printStackTrace();
                    } catch (JMSException e) {

                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
