package com.project.task_board.service.exceptions;

public class ColumnNotFoundException extends NotFoundException {

  public ColumnNotFoundException() {
    super("Board não encontrada!");
  }
}
