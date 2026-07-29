package com.yurifreitas.notificacao_api.consumer;

import com.yurifreitas.notificacao_api.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
	public void receive(String message) {
		System.out.println("Mensagem recebida: " + message);
	}
}
