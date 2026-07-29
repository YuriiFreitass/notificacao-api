package com.yurifreitas.notificacao_api.mapper;

import com.yurifreitas.notificacao_api.dto.UsuarioReponseDto;
import com.yurifreitas.notificacao_api.dto.UsuarioRequestDto;
import com.yurifreitas.notificacao_api.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	UsuarioEntity toEntity(UsuarioRequestDto requestDto);

	UsuarioReponseDto toResponseDto(UsuarioEntity entity);
}
