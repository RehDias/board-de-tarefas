package com.project.task_board.service.exceptions;

public class ReportNotFoundException extends NotFoundException {

  public ReportNotFoundException() {
    super("Relatório não encontrado!");
  }
}
