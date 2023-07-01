package hu.feladat.spring.config;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import hu.spring.feladat.openapi.model.Error;

@RestControllerAdvice
public class ExceptionHandler extends ResponseStatusExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);
    public static final String ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM = "Issue during Processing request, Please contact Application team";

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public static final ResponseEntity<Error> exceptionHandler(NullPointerException ex) {
    	Error exceptionResponse = new Error(ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM, OffsetDateTime.now());
        logError(ex,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalAccessException.class)
    public static final ResponseEntity<Error> exceptionHandler(IllegalAccessException ex) {
    	Error exceptionResponse = new Error("Access issue, please contact Application team", OffsetDateTime.now());
        logError(ex,HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public static final ResponseEntity<Error> exceptionHandler(RuntimeException ex) {
    	Error exceptionResponse = new Error(ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM, OffsetDateTime.now());
        logError(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public static final ResponseEntity<Error> exceptionHandler(Exception ex) {
    	Error exceptionResponse = new Error(ISSUE_DURING_PROCESSING_REQUEST_PLEASE_CONTACT_APPLICATION_TEAM, OffsetDateTime.now());
        logError(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static void logError(Exception exception, HttpStatus statusCode){
        log.error("Exception Cause Message : {}", exception.getMessage()+"\nException Localised Message : {}", exception.getLocalizedMessage()+ "\nReturned Status: {}", statusCode.MULTI_STATUS.value());
    }
}
