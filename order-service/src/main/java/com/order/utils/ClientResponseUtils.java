package com.order.utils;

import com.order.exception.BadRequestException;
import com.order.exception.InternalServerException;
import com.order.exception.TooManyRequestsException;
import com.order.exception.UnauthorizedException;
import com.order.models.error.ErrorDTO;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

public final class ClientResponseUtils {
    ClientResponseUtils(){}

    public static Mono<BadRequestException> toErrorDtoBadRequestException(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(ErrorDTO.class)
            .map(errorDTO -> new BadRequestException(errorDTO.getDescription(), errorDTO));
    }

    public static Mono<UnauthorizedException> toErrorUnauthorizedException(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(ErrorDTO.class)
            .map(errorDTO -> new UnauthorizedException(errorDTO.getDescription(), errorDTO));
    }

    public static Mono<TooManyRequestsException> toErrorDtoTooManyRequestsException(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(ErrorDTO.class)
            .map(errorDTO -> new TooManyRequestsException(errorDTO.getDescription(), errorDTO));
    }

    public static Mono<InternalServerException> toErrorDtoInternalServerException(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(ErrorDTO.class)
            .map(errorDTO -> new InternalServerException(errorDTO.getDescription(), errorDTO));
    }

}
