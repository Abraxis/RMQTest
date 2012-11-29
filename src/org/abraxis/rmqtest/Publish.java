package org.abraxis.rmqtest;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
public class Publish {

	private final static String QUEUE_NAME = "qHello";

	public static void main(String[] args) throws Exception {
		Logger logger = LoggerFactory.getLogger(Publish.class);
		logger.info("Hi!");
		
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello World!";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		logger.info("LOG: [x] Sent '" + message + "'");
		
		channel.close();
		connection.close();

	}
}
