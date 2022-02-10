package com.person.exception;


import com.person.models.error.ErrorDTO;

public class ErrorDTOException extends RuntimeException {

    private static final long serialVersionUID = -391271643930796506L;
    private final ErrorDTO errorDTO;

    public ErrorDTOException(String message) {
        super(message);
        this.errorDTO = null;
    }

    public ErrorDTOException(String message, ErrorDTO errorDTO) {
        super(message);
        this.errorDTO = errorDTO;
    }

    public ErrorDTO getErrorDTO() {
        return errorDTO;
    }

}
