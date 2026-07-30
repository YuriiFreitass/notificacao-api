package com.yurifreitas.notificacao_api.service;

import com.yurifreitas.notificacao_api.dto.UsuarioCriadoEvent;
import com.yurifreitas.notificacao_api.entity.NotificacaoEntity;
import com.yurifreitas.notificacao_api.enums.StatusNotificacao;
import com.yurifreitas.notificacao_api.repository.NotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

	private final NotificacaoRepository notificacaoRepository;

	public void save(UsuarioCriadoEvent event) {

		NotificacaoEntity notificacao = new NotificacaoEntity();

		notificacao.setUsuarioId(event.usuarioId());
		notificacao.setMensagem("Usuário criado com sucesso");
		notificacao.setStatus(StatusNotificacao.PENDENTE);
		notificacao.setDataCriacao(event.dataCadastro());

		notificacaoRepository.save(notificacao);
	}


}
