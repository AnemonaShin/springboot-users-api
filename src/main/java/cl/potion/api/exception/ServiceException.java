package cl.potion.api.exception;

import java.time.LocalDateTime;

public class ServiceException extends Exception {

  final String code;
  final String message;
  final LocalDateTime timeStamp;

  public ServiceException(String code, String message) {
    super();
    this.code = code;
    this.message = message;
    this.timeStamp = LocalDateTime.now();
  }
}
