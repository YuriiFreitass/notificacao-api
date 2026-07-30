package com.yurifreitas.notificacao_api.handle;

import com.yurifreitas.notificacao_api.dto.CampoErroDto;
import com.yurifreitas.notificacao_api.dto.ErrorResponseDto;
import com.yurifreitas.notificacao_api.exception.EmailDuplicadoException;
import com.yurifreitas.notificacao_api.exception.UsuarioNaoEncontradoException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandle {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException exception)
	{
		List<CampoErroDto> campos = exception
				.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(fieldError -> new CampoErroDto(
						fieldError.getField(),
						fieldError.getDefaultMessage()
				)).toList();
		ErrorResponseDto erro = new ErrorResponseDto(
				HttpStatus.BAD_REQUEST.value(), "Erro de validação", campos
		);
		return  ResponseEntity.badRequest().body(erro);
	}

	@ExceptionHandler(EmailDuplicadoException.class)
	public ResponseEntity<ErrorResponseDto> handleEmailDuplicadoException(
			EmailDuplicadoException exception) {
		ErrorResponseDto erro = new ErrorResponseDto(
				HttpStatus.CONFLICT.value(),
				exception.getMessage(),
				List.of()
		);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<ErrorResponseDto> handleUsuarioNaoEncontradoException(
			UsuarioNaoEncontradoException exception
	) {
		ErrorResponseDto erro = new ErrorResponseDto(
				HttpStatus.NOT_FOUND.value(),
				exception.getMessage(),
				List.of()
		);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
