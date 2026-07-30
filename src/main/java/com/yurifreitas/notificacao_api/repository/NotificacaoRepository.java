package com.yurifreitas.notificacao_api.repository;

import com.yurifreitas.notificacao_api.entity.NotificacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<NotificacaoEntity, Long> {
}
