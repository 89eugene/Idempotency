package com.person.utils;

import com.person.exception.BadRequestException;
import com.person.exception.InternalServerException;
import com.person.exception.TooManyRequestsException;
import com.person.exception.UnauthorizedException;
import com.person.models.error.ErrorDTO;
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
