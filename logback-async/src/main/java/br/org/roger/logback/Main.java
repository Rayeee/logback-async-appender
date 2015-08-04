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
package br.org.roger.logback;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.org.roger.util.Stopwatch;
import ch.qos.logback.classic.LoggerContext;

public class Main {
	
	private static final String JMS_LOGGER_CATEGORY = "JMS_LOGGER";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	private static final Logger JMS_LOGGER = LoggerFactory.getLogger(JMS_LOGGER_CATEGORY);

	public static void main(String[] args) {
		Stopwatch stopwatch = new Stopwatch();
		
		JMS_LOGGER.info("Message sent to the configured appender.");
				
		double elapsedTime = stopwatch.elapsedTimeInMillis();
		
		LOGGER.info("LOGGER.info() method took {} ms to execute", String.format("%1.12f", elapsedTime));
		
		ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory();
		if (loggerFactory instanceof LoggerContext) {
		    LoggerContext context = (LoggerContext) loggerFactory;
		    context.stop();
		}

	}
}
