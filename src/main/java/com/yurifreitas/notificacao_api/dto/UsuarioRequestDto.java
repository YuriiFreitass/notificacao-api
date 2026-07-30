package com.yurifreitas.notificacao_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDto (
		@NotBlank
		String nome,
		@NotBlank
		@Email
		String email
) {}
