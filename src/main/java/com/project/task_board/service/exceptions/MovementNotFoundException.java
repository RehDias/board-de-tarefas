package com.project.task_board.service.exceptions;

public class MovementNotFoundException extends NotFoundException {

  public MovementNotFoundException() {
    super("Movimento não encontrada!");
  }
}
