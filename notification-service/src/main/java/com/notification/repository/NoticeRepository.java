package com.notification.repository;

import com.notification.models.Notice;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRepository extends CrudRepository<Notice, Long> {

    List<Notice> findAllByLogin(String login);
}
