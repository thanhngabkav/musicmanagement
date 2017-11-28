package com.tma.ntnga.musicmanager.messageHandler;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class JmsTopicSubscriberFactory {

    private static JmsTopicSubscriber jmsTopicSubscriber = null;

    private static final String USER = "test";
    private static final String PASSWORD = "test";

    private JmsTopicSubscriberFactory(String destination) throws NamingException, JMSException {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
        env.put(Context.SECURITY_PRINCIPAL, USER);
        env.put(Context.SECURITY_CREDENTIALS, PASSWORD);

        Context ctx = new InitialContext(env);
        ConnectionFactory  factory = (ConnectionFactory ) ctx.lookup("jms/RemoteConnectionFactory");
        Connection connection = factory.createConnection(USER, PASSWORD);
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        connection.start();
        String destinationName = "jms/topic/" + destination;
        Topic topic = (Topic) ctx.lookup(destinationName);
        jmsTopicSubscriber = new JmsTopicSubscriber(session,topic,connection);
    }

    public static JmsTopicSubscriber getTopicSubscriberInstance(String destination) throws JMSException, NamingException {
        if(jmsTopicSubscriber == null){
            new JmsTopicSubscriberFactory(destination);
        }
        return jmsTopicSubscriber;
    }
}
