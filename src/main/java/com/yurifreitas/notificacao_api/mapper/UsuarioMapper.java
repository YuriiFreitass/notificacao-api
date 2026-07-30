package com.yurifreitas.notificacao_api.mapper;

import com.yurifreitas.notificacao_api.dto.UsuarioRequestDto;
import com.yurifreitas.notificacao_api.dto.UsuarioResponseDto;
import com.yurifreitas.notificacao_api.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	UsuarioEntity toEntity(UsuarioRequestDto requestDto);

	UsuarioResponseDto toResponseDto(UsuarioEntity entity);

	void updateEntityFromDto(
			UsuarioRequestDto usuarioRequestDto,
			@MappingTarget UsuarioEntity usuarioEntity
	);
}
