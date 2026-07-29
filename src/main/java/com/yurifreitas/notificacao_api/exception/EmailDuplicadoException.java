package com.yurifreitas.notificacao_api.exception;

public class EmailDuplicadoException extends RuntimeException {
	public EmailDuplicadoException(String message) {
		super(message);
	}
}
