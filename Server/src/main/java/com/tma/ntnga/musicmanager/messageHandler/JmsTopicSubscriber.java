package com.tma.ntnga.musicmanager.messageHandler;

import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.Topic;

public class JmsTopicSubscriber {

    private Session session;

    private Topic topic;

    private Connection connection;

    public JmsTopicSubscriber() {
    }

    public JmsTopicSubscriber(Session session, Topic topic, Connection connection) {
        this.session = session;
        this.topic = topic;
        this.connection = connection;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
