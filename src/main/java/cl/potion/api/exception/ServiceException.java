package cl.potion.api.exception;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ServiceException extends Exception {

  final String code;
  final HttpStatus httpStatus;
  final String message;
  final LocalDateTime timeStamp;

  public ServiceException(HttpStatus httpStatus, String code, String message) {
    this.httpStatus = httpStatus;
    this.code = code;
    this.message = message;
    this.timeStamp = LocalDateTime.now(ZoneId.of("America/Santiago"));
  }

  public ServiceException(ExceptionList exceptionList) {
    this.httpStatus = exceptionList.getHttpStatus();
    this.code = exceptionList.getCode();
    this.message = exceptionList.getMessage();
    this.timeStamp = LocalDateTime.now(ZoneId.of("America/Santiago"));
  }
}
