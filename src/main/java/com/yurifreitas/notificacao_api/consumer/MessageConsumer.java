package com.yurifreitas.notificacao_api.consumer;

import com.yurifreitas.notificacao_api.config.RabbitMQConfig;
import com.yurifreitas.notificacao_api.dto.UsuarioCriadoEvent;
import com.yurifreitas.notificacao_api.service.NotificacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageConsumer {

	private final NotificacaoService notificacaoService;

	@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
	public void receberUsuarioCriado(UsuarioCriadoEvent event) {
		notificacaoService.save(event);
	}
}