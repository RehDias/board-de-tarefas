package com.project.task_board.dto;

import com.project.task_board.entity.Movement;
import com.project.task_board.utils.ColumnType;
import java.time.LocalDateTime;

public record MovementDto(Long id, ColumnType colunaAnterior , ColumnType colunaAtual) {

  public static MovementDto fromEntity(Movement movement) {
    return new MovementDto(
        movement.getId(),
        movement.getColunaAnterior(),
        movement.getColunaAtual()
    );
  }
}
