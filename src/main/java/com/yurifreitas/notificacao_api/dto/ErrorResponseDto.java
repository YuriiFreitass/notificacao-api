package com.yurifreitas.notificacao_api.dto;

import java.util.List;

public record ErrorResponseDto(
		int status,
		String mensagem,
		List<CampoErroDto> campos
) {
}
