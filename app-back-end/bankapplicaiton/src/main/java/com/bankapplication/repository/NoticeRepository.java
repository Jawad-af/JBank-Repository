package com.bankapplication.repository;

import com.bankapplication.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
    @Query(value = "SELECT * FROM notice_details", nativeQuery = true)
    List<Notice> findAllNotices();
}
