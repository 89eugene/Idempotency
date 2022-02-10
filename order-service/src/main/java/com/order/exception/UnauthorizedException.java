package com.order.exception;

import com.order.models.error.ErrorDTO;

public class UnauthorizedException extends ErrorDTOException {

    private static final long serialVersionUID = -7652749437988280699L;

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message,  ErrorDTO errorDTO) {
        super(message, errorDTO);
    }
}
