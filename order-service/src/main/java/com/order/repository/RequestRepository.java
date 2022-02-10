package com.order.repository;

import com.order.models.Request;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {

    Optional<Request> findByRequestId(String requestId);
}
