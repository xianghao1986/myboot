package com.wtsd.jms;

import com.sun.messaging.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by xianghao on 2017/6/1.
 */
@Configuration
public class MQInit {
    private @Value("${jms.send.dest}") String dest;
    private @Value("${jms.server.addr}") String addr;

    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try {
            connectionFactory.setProperty("imqAddressList", addr);
            connectionFactory.setProperty("imqReconnectEnabled", "true");
            connectionFactory.setProperty("imqReconnectAttempts", "3");
            connectionFactory.setProperty("imqReconnectInterval", "5000");
        } catch (JMSException e) {
//			log.error(null,e);
        }
        return connectionFactory;
    }

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
        endpoint.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.err.println("onMessage:"+message);
            }
        });
//		endpoint.setDestination("QL_TEST22");
        SimpleMessageListenerContainer container = factory.createListenerContainer(endpoint);
        container.setConnectionFactory(connectionFactory);
		container.setDestinationName(dest);
        container.setConcurrentConsumers(100);
//		container.setMessageListener(jmsMsgListener());
        return factory;
    }



    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
        return new JmsTemplate(connectionFactory);
    }


}
