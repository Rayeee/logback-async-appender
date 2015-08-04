/*
   Copyright 2015 Marcos R. Oliveira
   
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
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