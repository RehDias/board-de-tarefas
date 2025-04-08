package com.project.task_board.service.exceptions;

public class CardNotFoundException extends NotFoundException {

  public CardNotFoundException() {
    super("Board não encontrada!");
  }
}
