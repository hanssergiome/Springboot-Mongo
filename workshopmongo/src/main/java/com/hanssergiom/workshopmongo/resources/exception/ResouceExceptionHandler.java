package com.hanssergiom.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hanssergiom.workshopmongo.services.exception.ObjectNotFoundException;

public class ResouceExceptionHandler {

	@ControllerAdvice
	public class ResourceExceptionHandler {
		@ExceptionHandler(ObjectNotFoundException.class)

		// Quando estourar no serviço essa exceção, gerará um erro e retornará um objeto
		public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

			HttpStatus status = HttpStatus.NOT_FOUND;
			StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado", e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(status).body(error);
		}

	}
}
