package com.person.repository;

import com.person.models.Account;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByLogin(String login);
}
