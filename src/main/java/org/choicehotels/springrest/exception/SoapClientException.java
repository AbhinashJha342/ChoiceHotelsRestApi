package org.choicehotels.springrest.exception;

import org.springframework.http.HttpStatus;

public class SoapClientException extends RuntimeException {

    private String errorMessage;

    private HttpStatus status;

    public SoapClientException(String errorMessage, HttpStatus status) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
