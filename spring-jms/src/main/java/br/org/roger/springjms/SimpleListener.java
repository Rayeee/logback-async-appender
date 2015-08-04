package br.org.roger.springjms;

import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.spi.LoggingEventVO;

@Component
public class SimpleListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleListener.class);
    
    @JmsListener(destination = "queue.logback-queue")
    public void receiveOrder(Message message) throws JMSException {
    	LoggingEventVO loggingEventVO = (LoggingEventVO) ((ActiveMQObjectMessage)message).getObject();
    	
    	LOGGER.info("Message '{}' received.", loggingEventVO.getMessage());
    }
}