package com.project.task_board.service;

import com.project.task_board.entity.Column;
import com.project.task_board.repository.ColumnRepository;
import com.project.task_board.utils.ColumnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColumnService {
  private final ColumnRepository columnRepository;

  @Autowired
  public ColumnService(ColumnRepository columnRepository) {
    this.columnRepository = columnRepository;
  }

  public Column createColumn(
      Long boardId,
      Long cardId,
      String nome,
      ColumnType columnType,
      int ordem) {

  }
}
