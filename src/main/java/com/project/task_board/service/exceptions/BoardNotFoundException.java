package com.project.task_board.service.exceptions;

public class BoardNotFoundException extends NotFoundException {

  public BoardNotFoundException() {
    super("Board não encontrada!");
  }
}
