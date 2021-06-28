package com.helpeachother.secretcode.log.repository;

import com.helpeachother.secretcode.log.entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends JpaRepository<Logs, Long> {

}
