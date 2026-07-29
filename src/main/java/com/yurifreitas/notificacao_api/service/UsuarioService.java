package com.yurifreitas.notificacao_api.service;

import com.yurifreitas.notificacao_api.dto.UsuarioReponseDto;
import com.yurifreitas.notificacao_api.dto.UsuarioRequestDto;
import com.yurifreitas.notificacao_api.entity.UsuarioEntity;
import com.yurifreitas.notificacao_api.exception.EmailDuplicadoException;
import com.yurifreitas.notificacao_api.mapper.UsuarioMapper;
import com.yurifreitas.notificacao_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;

	public UsuarioReponseDto save(String email, UsuarioRequestDto usuarioRequestDto) {
		if (usuarioRepository.existsEmail(email)) {
			throw new EmailDuplicadoException("Esse email já está cadastrado");
		}
		UsuarioEntity usuario = usuarioMapper.toEntity(usuarioRequestDto);
		UsuarioEntity usuarioCadastrado = usuarioRepository.save(usuario);

		return usuarioMapper.toResponseDto(usuarioCadastrado);

	}
}

