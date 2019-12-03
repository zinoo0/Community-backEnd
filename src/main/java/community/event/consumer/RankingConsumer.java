package community.event.consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import community.service.RankingService;

@Service
public class RankingConsumer {

	public static String AMQP_HOST = "ec2-13-209-6-54.ap-northeast-2.compute.amazonaws.com";
	public static String AMQP_USERNAME = "rabbitmq";
	public static String AMQP_PASSWORD = "password123";
	
	@Autowired
	RankingService service;
	
	public void consume(String queueName) throws Exception {		
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(AMQP_HOST);
		factory.setUsername(AMQP_USERNAME);
		factory.setPassword(AMQP_PASSWORD);
		
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(queueName , false, false, false, null);
	    
	    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
	        String message = new String(delivery.getBody(), "UTF-8");
	        
	        // 큐 메시지 처리 후 ranking service 로 이동
	        service.processQueueMessage(message);
	    };
	    channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });	
	}

	
}
