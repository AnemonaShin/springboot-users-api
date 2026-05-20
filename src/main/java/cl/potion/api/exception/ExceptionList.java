package cl.potion.api.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ExceptionList {

    UNFD(HttpStatus.NOT_FOUND, "404", "USER NOT FOUND"),
    USAA(HttpStatus.CONFLICT, "409", "USER ALREADY ACTIVATED"),
    USAD(HttpStatus.CONFLICT, "409", "USER ALREADY DEACTIVATED"),
    USDCU(HttpStatus.NOT_MODIFIED, "304", "CANT UPDATE A DEACTIVATED USER"),
    USDCS(HttpStatus.CONFLICT, "409", "CANT SEARCH A DEACTIVATED USER");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    private ExceptionList(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
