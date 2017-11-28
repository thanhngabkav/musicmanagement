package com.tma.ntnga.musicmanager.messageHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tma.ntnga.musicmanager.models.MusicManagerMessage;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import javax.jms.*;
import javax.naming.NamingException;
import java.io.IOException;

@Component
public class MusicMessageHandler{

    static Logger log = Logger.getLogger(MusicMessageHandler.class.getName());

    /**
     * Send message to another subscribers
     * @param musicManagerMessage : MusicManagerMessage
     */
    public void sendMessage(MusicManagerMessage musicManagerMessage) throws NamingException, JMSException, JsonProcessingException {
        JmsTopicSubscriber topicSubscriber = JmsTopicSubscriberFactory.getTopicSubscriberInstance("musicManager");
        Session session = topicSubscriber.getSession();
        Topic topic = topicSubscriber.getTopic();
        MessageProducer publisher = session.createProducer(topic);
        MessageConverter messageConverter = new MessageConverter();
        TextMessage message = session.createTextMessage(messageConverter.toTextMessage(musicManagerMessage));
        publisher.send(message);
        log.info("Sending Message: " + musicManagerMessage.toString());
    }

    /**
     * On message received
     * @throws NamingException
     * @throws JMSException
     */
    public void receiveMessage() throws NamingException, JMSException {
            JmsTopicSubscriber topicSubscriber = JmsTopicSubscriberFactory.getTopicSubscriberInstance("musicManager");
            Session session = topicSubscriber.getSession();
            Topic topic = topicSubscriber.getTopic();
            MessageConsumer messageConsumer = session.createConsumer(topic);
            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage)message;
                    MessageConverter  messageConverter = new MessageConverter();
                    MusicManagerMessage musicManagerMessage = new MusicManagerMessage();
                    try {
                        musicManagerMessage = messageConverter.toMusicManagerMessage(textMessage.getText());
                    } catch (IOException e) {
                        log.error("Can not parse to MusicManagerMessage: ");
                        e.printStackTrace();
                    } catch (JMSException e) {
                        log.error("textMessage.getText() Error:");
                        e.printStackTrace();
                    }
                    //Handle message here
                    log.info("Receive message: "+ musicManagerMessage.toString());
                }
            });
    }

}
