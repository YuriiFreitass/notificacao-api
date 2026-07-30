package com.yurifreitas.notificacao_api.entity;

import com.yurifreitas.notificacao_api.enums.StatusNotificacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "notificacoes_tb")
public class NotificacaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long usuarioId;

	private String mensagem;

	@Enumerated(EnumType.STRING)
	private StatusNotificacao status;

	private LocalDateTime dataCriacao;
}
