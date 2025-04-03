package com.project.task_board.repository;

import com.project.task_board.entity.LockReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockReportRepository extends JpaRepository<LockReport, Long> {

}
