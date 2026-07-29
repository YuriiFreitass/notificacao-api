package com.yurifreitas.notificacao_api;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class NotificacaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacaoApiApplication.class, args);
	}

}
