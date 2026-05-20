package cl.potion.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cl.potion.api.response.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ServiceException.class)
  public ResponseEntity<ExceptionResponse> handleGlobalException(ServiceException serviceException) {

    return new ResponseEntity<>(ExceptionResponse.builder()
        .code(serviceException.getCode())
        .message(serviceException.getMessage())
        .timestamp(serviceException.getTimeStamp()).build(), serviceException.getHttpStatus());

  }
}
