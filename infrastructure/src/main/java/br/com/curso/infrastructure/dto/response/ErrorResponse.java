package br.com.curso.infrastructure.dto.response;

public record ErrorResponse(
         String code,
         String message,
         List<ValidationError> validations
) {




}
