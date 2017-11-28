package com.tma.ntnga.musicmanager.messageHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tma.ntnga.musicmanager.entities.Song;
import com.tma.ntnga.musicmanager.models.MessageStatus;
import com.tma.ntnga.musicmanager.models.MusicManagerMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;
import javax.naming.NamingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicMessageHandlerTest {

    @Autowired
    private MusicMessageHandler musicMessageHandler;

    @Test
    public void testSend_ReceiveMessage() throws JMSException, NamingException, JsonProcessingException {
        Song song = new Song(1,"banana","google.com");
        MusicManagerMessage musicManagerMessage =
                new MusicManagerMessage(MessageStatus.CREATED,song);
        musicMessageHandler.sendMessage(musicManagerMessage);
        MusicManagerMessage expectedResult = musicManagerMessage;
       // MusicManagerMessage actualResult = musicMessageHandler.receiveMessage();
    }

}
