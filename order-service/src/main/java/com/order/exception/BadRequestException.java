package com.order.exception;


import com.order.models.error.ErrorDTO;

public class BadRequestException extends ErrorDTOException {

    private static final long serialVersionUID = 1325126005336446072L;

    public BadRequestException(String message, ErrorDTO errorDTO) {
        super(message, errorDTO);
    }
}
