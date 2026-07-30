package com.yurifreitas.notificacao_api.controller;

import com.yurifreitas.notificacao_api.dto.UsuarioRequestDto;
import com.yurifreitas.notificacao_api.dto.UsuarioResponseDto;
import com.yurifreitas.notificacao_api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<UsuarioResponseDto> findAll(Pageable pageable) {
		return usuarioService.findAll(pageable);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioResponseDto findById(@PathVariable Long id) {
		return usuarioService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDto save(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
		return usuarioService.save(usuarioRequestDto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioResponseDto update(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
		return usuarioService.update(id, usuarioRequestDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.deleteById(id);
	}
}
