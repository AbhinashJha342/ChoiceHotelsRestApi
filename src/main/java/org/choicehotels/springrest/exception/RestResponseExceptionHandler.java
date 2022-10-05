package org.choicehotels.springrest.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.ws.client.WebServiceIOException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("inside argument not valid"+ ex.getLocalizedMessage());
        ErrorData error = new ErrorData(HttpStatus.BAD_REQUEST);
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        error.setMessage(Collections.singletonMap("errors", errors).toString());
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(SoapClientException.class)
    public ResponseEntity<Object> handleSoapClientException(SoapClientException ex) {
        ErrorData error = new ErrorData(ex.getStatus());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(WebServiceIOException.class)
    public ResponseEntity<Object> handleWebServiceException(WebServiceIOException ex){
        ErrorData error = new ErrorData(HttpStatus.SERVICE_UNAVAILABLE);
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, error.getStatus());
    }

}
