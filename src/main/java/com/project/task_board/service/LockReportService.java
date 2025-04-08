package com.project.task_board.service;

import com.project.task_board.entity.Board;
import com.project.task_board.entity.Card;
import com.project.task_board.entity.LockReport;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LockReportService {
  public List<LockReport> generateLockReports(Board board) {
    List<LockReport> reports = new ArrayList<>();

    board.getColunas().forEach(column -> {
      column.getCards().stream()
          .filter(Card::isBloqueado)
          .forEach(card -> {
            LockReport lr = new LockReport();
            lr.setCard(card);
            lr.setDataBloqueio(card.getDataBloqueio());
            lr.setDataDesbloqueio(card.getDataDesbloqueio());
            lr.setMotivoBloqueio(card.getMotivoBloqueio());

            if (card.getDataBloqueio() != null && card.getDataDesbloqueio() != null) {
              long tempo = ChronoUnit.DAYS.between(card.getDataBloqueio(), card.getDataDesbloqueio());
              lr.setTempoBloqueado(tempo);
            }

            reports.add(lr);
          });
    });

    return reports;
  }
}
