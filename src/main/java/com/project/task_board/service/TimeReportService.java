package com.project.task_board.service;

import com.project.task_board.entity.Board;
import com.project.task_board.entity.Movement;
import com.project.task_board.entity.TimeReport;
import com.project.task_board.repository.MovementRepository;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeReportService {
  private final MovementRepository movementRepository;

  @Autowired
  public TimeReportService(MovementRepository movementRepository) {
    this.movementRepository = movementRepository;
  }

  public List<TimeReport> generateTimeReports(Board board) {
    List<TimeReport> reports = new ArrayList<>();

    board.getColunas().forEach(column -> {
      column.getCards().forEach(card -> {
        List<Movement> movements = movementRepository.findByCardOrderByDataHoraEntrada(card);

        for (Movement movement : movements) {
          if (movement.getDataHoraEntrada() != null && movement.getDataHoraSaida() != null) {
            TimeReport tr = new TimeReport();
            tr.setCard(card);
            tr.setColunaInicial(column);
            tr.setColunaFinal(column);
            long tempo = ChronoUnit.MINUTES.between(
                movement.getDataHoraEntrada(), movement.getDataHoraSaida());
            tr.setTempoTotal(tempo);
            reports.add(tr);
          }
        }
      });
    });

    return reports;
  }
}
