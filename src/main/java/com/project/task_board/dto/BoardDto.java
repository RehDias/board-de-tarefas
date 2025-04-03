package com.project.task_board.dto;

import com.project.task_board.entity.Board;
import com.project.task_board.entity.Column;
import com.project.task_board.entity.Report;
import java.util.List;

public record BoardDto(String nome, List<Column> colunas, List<Report> reports) {
 public static BoardDto fromEntity(Board board) {
   return new BoardDto(
       board.getNome(),
       board.getColunas(),
       board.getReports()
   );
 }
}
