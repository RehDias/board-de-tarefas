package com.project.task_board.service;

import com.project.task_board.entity.Board;
import com.project.task_board.entity.LockReport;
import com.project.task_board.entity.Report;
import com.project.task_board.entity.TimeReport;
import com.project.task_board.repository.ReportRepository;
import com.project.task_board.service.exceptions.BoardNotFoundException;
import com.project.task_board.service.exceptions.ReportNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

  private final ReportRepository reportRepository;
  private final BoardService boardService;
  private final LockReportService lockReportService;
  private final TimeReportService timeReportService;

  @Autowired
  public ReportService(ReportRepository reportRepository, BoardService boardService,
      LockReportService lockReportService, TimeReportService timeReportService) {
    this.reportRepository = reportRepository;
    this.boardService = boardService;
    this.lockReportService = lockReportService;
    this.timeReportService = timeReportService;
  }

  public Report generateReport(Long boardId) throws BoardNotFoundException {
    Board board = boardService.findBoardById(boardId);
    Report report = new Report();
    report.setBoard(board);

    List<LockReport> lockReports = lockReportService.generateLockReports(board);
    lockReports.forEach(lr -> lr.setReport(report));
    report.setBloqueios(lockReports);

    List<TimeReport> timeReports = timeReportService.generateTimeReports(board);
    timeReports.forEach(tr -> tr.setReport(report));
    report.setTempos(timeReports);

    return reportRepository.save(report);
  }

  public List<Report> listAllReports() {
    return reportRepository.findAll();
  }

  public Report getReportById(Long id) throws ReportNotFoundException {
    return reportRepository.findById(id).orElseThrow(ReportNotFoundException::new);
  }
}
