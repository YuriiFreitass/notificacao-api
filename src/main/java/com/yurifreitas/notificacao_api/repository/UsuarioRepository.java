package com.yurifreitas.notificacao_api.repository;

import com.yurifreitas.notificacao_api.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	boolean existsByEmail(String email);
}
