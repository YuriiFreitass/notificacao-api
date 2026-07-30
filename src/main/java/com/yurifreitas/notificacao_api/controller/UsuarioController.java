package com.yurifreitas.notificacao_api.controller;

import com.yurifreitas.notificacao_api.dto.UsuarioRequestDto;
import com.yurifreitas.notificacao_api.dto.UsuarioResponseDto;
import com.yurifreitas.notificacao_api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Usuários", description = "Endpoints para cadastro de usuários")
@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Operation(summary = "Listar usuários")
	@ApiResponse(responseCode = "200", description = "Usuários retornados com sucesso")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<UsuarioResponseDto> findAll(Pageable pageable) {
		return usuarioService.findAll(pageable);
	}

	@Operation(summary = "Buscar usuários por ID")
	@ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
	@ApiResponse(responseCode = "404", description = "Usuário não encontrado")
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioResponseDto findById(@PathVariable Long id) {
		return usuarioService.findById(id);
	}

	@Operation(summary = "Cadastrar usuários")
	@ApiResponse(responseCode = "200", description = "Usuários cadastrados com sucesso")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDto save(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
		return usuarioService.save(usuarioRequestDto);
	}

	@Operation(summary = "Atualizar usuário")
	@ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioResponseDto update(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
		return usuarioService.update(id, usuarioRequestDto);
	}

	@Operation(summary = "Excluir usuário")
	@ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.deleteById(id);
	}
}
