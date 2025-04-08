package com.project.task_board.service;

import com.project.task_board.entity.Board;
import com.project.task_board.entity.Column;
import com.project.task_board.repository.BoardRepository;
import com.project.task_board.service.exceptions.BoardNotFoundException;
import com.project.task_board.utils.ColumnType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  private final BoardRepository boardRepository;

  @Autowired
  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  public Board createNewBoard(String nome) {
    Board board = new Board();
    board.setNome(nome);
    board.setColunas(criarColunasPadrao(board));

    return boardRepository.save(board);
  }

  private List<Column> criarColunasPadrao(Board board) {
    List<Column> columns = new ArrayList<>();
    columns.add(new Column("To Do", ColumnType.INICIAL, 0, board));
    columns.add(new Column("In Progress", ColumnType.PENDENTE, 1, board));
    columns.add(new Column("Done", ColumnType.FINAL, 2, board));
    columns.add(new Column("Cancelled", ColumnType.CANCELAMENTO, 3, board));
    return columns;
  }

  public List<Board> listBoards() {
    return boardRepository.findAll();
  }

  public Board findBoardById(Long id) throws BoardNotFoundException {
    return boardRepository.findById(id)
        .orElseThrow(BoardNotFoundException::new);
  }

  public void deleteBoard(Long id) throws BoardNotFoundException {
    if (!boardRepository.existsById(id)) {
      throw new BoardNotFoundException();
    }
    boardRepository.deleteById(id);
  }
}

