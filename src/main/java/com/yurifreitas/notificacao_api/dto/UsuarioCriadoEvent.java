package com.yurifreitas.notificacao_api.dto;

import java.time.LocalDate;

public record UsuarioCriadoEvent(
		Long usuarioId,
		String nome,
		String email,
		LocalDate dataCadastro
) {}
