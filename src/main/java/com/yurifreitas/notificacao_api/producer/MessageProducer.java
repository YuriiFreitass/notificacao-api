package com.yurifreitas.notificacao_api.producer;

import com.yurifreitas.notificacao_api.config.RabbitMQConfig;
import com.yurifreitas.notificacao_api.dto.UsuarioCriadoEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(UsuarioCriadoEvent event) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "usuarios.criado.#", event);
	}
}
