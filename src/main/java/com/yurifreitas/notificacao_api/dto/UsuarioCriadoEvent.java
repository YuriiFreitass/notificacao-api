package com.yurifreitas.notificacao_api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UsuarioCriadoEvent(
		Long usuarioId,
		String nome,
		String email,
		LocalDateTime dataCadastro
) {}
