package com.person.exception;


import com.person.models.error.ErrorDTO;

/**
 * Исключение, выбрасываемое при превышении допустимого количества запросов
 */
public class TooManyRequestsException extends ErrorDTOException {

    private static final long serialVersionUID = -4422769444681406773L;

    public TooManyRequestsException(String message, ErrorDTO errorDTO) {
        super(message, errorDTO);
    }
}
