package com.person.repository;

import com.person.models.OperationHistory;
import org.springframework.data.repository.CrudRepository;

public interface OperationHistoryRepository extends CrudRepository<OperationHistory, Long> {
}
