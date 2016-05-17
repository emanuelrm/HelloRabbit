package br.com.rabbit.helloRabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	private final static String QUEUE_NAME = "hello";

	public Boolean enviarMensagemFila(String msg) {

		try {
			
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
			System.out.println(" [x] Sent '" + msg + "'");
			
			channel.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
	
	public static void main(String[] args) {
		Send send = new Send();
		
		for (int i = 0; i < 100000; i++) {
			send.enviarMensagemFila("Test" + i);
		}
	}

}
