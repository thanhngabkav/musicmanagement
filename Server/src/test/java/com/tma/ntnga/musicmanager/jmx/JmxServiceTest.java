package com.tma.ntnga.musicmanager.jmx;

import com.tma.ntnga.musicmanager.entities.Song;
import com.tma.ntnga.musicmanager.services.SongService;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class JmxServiceTest {
    public static void main(String[] args) throws NamingException, IOException {
        //Get a connection to the JBoss AS MBean server on localhost
        String host = "127.0.0.1";
        int port = 9990;  // management-native port
        String urlString =
                System.getProperty("jmx.service.url","service:jmx:remoting-jmx://" + host + ":" + port);
        JMXServiceURL serviceURL = new JMXServiceURL(urlString);
        JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceURL, null);
        MBeanServerConnection connection = jmxConnector.getMBeanServerConnection();

        //Invoke on the JBoss AS MBean server
        int count = connection.getMBeanCount();
        System.out.println(count);
        jmxConnector.close();
    }
}
