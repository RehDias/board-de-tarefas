package com.project.task_board.service;

import com.project.task_board.entity.Column;
import com.project.task_board.repository.ColumnRepository;
import com.project.task_board.service.BoardService;
import com.project.task_board.utils.ColumnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColumnService {
  private final ColumnRepository columnRepository;
  private final BoardService boardService;
  private final CardService cardService;

  @Autowired
  public ColumnService(
    ColumnRepository columnRepository, 
    BoardService boardService,
    CardService cardService
    ) {
    this.columnRepository = columnRepository;
    this.boardService = boardService;
    this.cardService = cardService;
  }

  public Column createColumn(
      Long boardId,
      Long cardId,
      String nome,
      ColumnType columnType,
      int ordem) throws BoardNotFoundException, CardNotFoundException {

      Board board = boardService.findBoardById(boardId);
      Card card = cardSer.findCardById(cardId);

      Column newColumn = new Column();
      newColumn.setBoard(board);
      newColumn.getCards().add(card);
      newColumn.setNome(nome);
      newColumn.setTipo(columnType);
      newColumn.setOrdem(ordem);

      return columnRepository.save(newColumn);
  }

  public Column findaColumnById(Long id) throws ColumnNotFoundException {
    return columnRepository.findById(id).orElseThrow(ColumnNotFoundException::new);
  }
}
