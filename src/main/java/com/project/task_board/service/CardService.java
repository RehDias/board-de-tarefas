package com.project.task_board.service;

import com.project.task_board.entity.Board;
import com.project.task_board.entity.Card;
import com.project.task_board.entity.Column;
import com.project.task_board.repository.CardRepository;
import com.project.task_board.service.exceptions.BoardNotFoundException;
import com.project.task_board.utils.ColumnType;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
  private final CardRepository cardRepository;
  private final BoardService boardService;

  @Autowired
  public CardService(CardRepository cardRepository,BoardService boardService) {
    this.cardRepository = cardRepository;
    this.boardService = boardService;
  }

  public Card createCard(String titulo, String descricao, Long boardId)
      throws BoardNotFoundException {
    Board board = boardService.findBoardById(boardId);
    Column initialColumn = board.getColunas().stream()
        .filter(c -> c.getTipo() == ColumnType.INICIAL)
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Board não possui coluna inicial"));

    Card card = new Card();
    card.setTitulo(titulo);
    card.setDescricao(descricao);
    card.setDataCriacao(LocalDate.now());
    card.setColumn(initialColumn);
    card.setBloqueado(false);


  }
}
