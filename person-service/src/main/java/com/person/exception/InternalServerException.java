package com.person.exception;


import com.person.models.error.ErrorDTO;

public class InternalServerException extends ErrorDTOException {

    private static final long serialVersionUID = 3562946005883346201L;

    public InternalServerException(String message) {
        super(message);
    }
    public InternalServerException(String message, ErrorDTO errorDTO) {
        super(message, errorDTO);
    }
}
