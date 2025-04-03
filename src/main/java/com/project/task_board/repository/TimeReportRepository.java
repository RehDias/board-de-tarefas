package com.project.task_board.repository;

import com.project.task_board.entity.TimeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeReportRepository extends JpaRepository<TimeReport, Long> {

}
