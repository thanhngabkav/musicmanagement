package com.tma.ntnga.musicmanager.messageHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tma.ntnga.musicmanager.models.MusicManagerMessage;


import java.io.IOException;

public class MessageConverter {

    /**
     * Convert from text Message to MusicManagerMessage
     * @param textMessage
     * @return MusicManagerMessage
     * @throws IOException
     */
    public MusicManagerMessage toMusicManagerMessage(String textMessage) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MusicManagerMessage message = objectMapper.readValue(textMessage, MusicManagerMessage.class);
        return  message;
    }

    /**
     * Convert from MusicManagerMessage to textMessage
     * @param musicManagerMessage
     * @return String
     * @throws JsonProcessingException
     */
    public String toTextMessage(MusicManagerMessage musicManagerMessage) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String textMessage = objectMapper.writeValueAsString(musicManagerMessage);
        return textMessage;
    }
}
