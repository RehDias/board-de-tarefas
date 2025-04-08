package com.project.task_board.service;

import com.project.task_board.entity.Card;
import com.project.task_board.entity.Movement;
import com.project.task_board.repository.MovementRepository;
import com.project.task_board.service.exceptions.MovementNotFoundException;
import com.project.task_board.utils.ColumnType;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovementService {
  private final MovementRepository movementRepository;

  public MovementService(MovementRepository movementRepository) {
    this.movementRepository = movementRepository;
  }

  public Movement registerEntry(Card card, ColumnType colunaAnterior, ColumnType colunaAtual) {
    Movement movement = new Movement();
    movement.setCard(card);
    movement.setColunaAnterior(colunaAnterior);
    movement.setColunaAtual(colunaAtual);
    movement.setDataHoraEntrada(LocalDateTime.now());

    return movementRepository.save(movement);
  }

  public void registerExit(Card card) throws MovementNotFoundException {
    Movement movement = movementRepository.findTopByCardOrderByDataHoraEntradaDesc(card)
        .orElseThrow(MovementNotFoundException::new);

    if (movement.getDataHoraSaida() == null) {
      movement.setDataHoraSaida(LocalDateTime.now());
      movementRepository.save(movement);
    }
  }

  public List<Movement> listMovementByCard(Long cardId) {
    return movementRepository.findByCardIdOrderByDataEntrada(cardId);
  }

  public List<Movement> listMovementByBoard(Long boardId) {
    return movementRepository.findByCard_Coluna_Board_IdOrderByDataHoraEntrada(boardId);
  }

}
