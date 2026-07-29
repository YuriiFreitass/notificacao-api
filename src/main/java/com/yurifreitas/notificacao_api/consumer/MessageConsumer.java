package com.yurifreitas.notificacao_api.consumer;

import com.yurifreitas.notificacao_api.config.RabbitMQConfig;
import com.yurifreitas.notificacao_api.dto.UsuarioCriadoEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
	public void receive(UsuarioCriadoEvent event) {

		System.out.println("====================================");
		System.out.println("Mensagem recebida");
		System.out.println("ID: " + event.usuarioId());
		System.out.println("Nome: " + event.nome());
		System.out.println("E-mail: " + event.email());
		System.out.println("Data: " + event.dataCadastro());
		System.out.println("====================================");
	}
}