package com.yurifreitas.notificacao_api.controller;

import com.yurifreitas.notificacao_api.dto.UsuarioReponseDto;
import com.yurifreitas.notificacao_api.dto.UsuarioRequestDto;
import com.yurifreitas.notificacao_api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioReponseDto save(String email, @Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
		return usuarioService.save(email,usuarioRequestDto);
	}
}
