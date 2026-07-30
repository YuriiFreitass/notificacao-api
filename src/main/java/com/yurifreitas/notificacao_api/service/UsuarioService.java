package com.yurifreitas.notificacao_api.service;

import com.yurifreitas.notificacao_api.dto.UsuarioCriadoEvent;
import com.yurifreitas.notificacao_api.dto.UsuarioRequestDto;
import com.yurifreitas.notificacao_api.dto.UsuarioResponseDto;
import com.yurifreitas.notificacao_api.entity.UsuarioEntity;
import com.yurifreitas.notificacao_api.exception.EmailDuplicadoException;
import com.yurifreitas.notificacao_api.exception.UsuarioNaoEncontradoException;
import com.yurifreitas.notificacao_api.mapper.UsuarioMapper;
import com.yurifreitas.notificacao_api.producer.MessageProducer;
import com.yurifreitas.notificacao_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;
	private final MessageProducer messageProducer;

	public Page<UsuarioResponseDto> findAll(Pageable pageable) {
		return usuarioRepository.findAll(pageable).map(usuarioMapper::toResponseDto);
	}

	public UsuarioResponseDto findById(Long id ) {
		UsuarioEntity usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado"));
		return usuarioMapper.toResponseDto(usuario);
	}

	public UsuarioResponseDto save(String email, UsuarioRequestDto usuarioRequestDto) {
		if (usuarioRepository.existsByEmail(email)) {
			throw new EmailDuplicadoException("Esse email já está cadastrado");
		}
		UsuarioEntity usuario = usuarioMapper.toEntity(usuarioRequestDto);
		UsuarioEntity usuarioCadastrado = usuarioRepository.save(usuario);
		UsuarioCriadoEvent event = new UsuarioCriadoEvent(
				usuarioCadastrado.getId(),
				usuarioCadastrado.getNome(),
				usuarioCadastrado.getEmail(),
				LocalDateTime.now()
		);
		messageProducer.send(event);

		return usuarioMapper.toResponseDto(usuarioCadastrado);

	}

	public UsuarioResponseDto update(Long id, UsuarioRequestDto usuarioRequestDto) {
		UsuarioEntity usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("O usuario não foi encontrado"));
		usuarioMapper.updateEntityFromDto(usuarioRequestDto, usuario);
		UsuarioEntity usuarioCadastrado = usuarioRepository.save(usuario);

		return usuarioMapper.toResponseDto(usuarioCadastrado);
	}

	public void deleteById(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("O usuario com ID" + id + " não foi encontrado"));
		usuarioRepository.delete(usuario);
	}
}

