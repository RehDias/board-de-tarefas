package com.project.task_board.service;

import static com.project.task_board.utils.ColumnType.CANCELAMENTO;

import com.project.task_board.entity.Board;
import com.project.task_board.entity.Card;
import com.project.task_board.entity.Column;
import com.project.task_board.entity.Movement;
import com.project.task_board.repository.CardRepository;
import com.project.task_board.service.exceptions.BoardNotFoundException;
import com.project.task_board.service.exceptions.CardNotFoundException;
import com.project.task_board.service.exceptions.MovementNotFoundException;
import com.project.task_board.utils.ColumnType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
  private final CardRepository cardRepository;
  private final BoardService boardService;
  private final MovementService movementService;

  @Autowired
  public CardService(CardRepository cardRepository,BoardService boardService,
      MovementService movementService) {
    this.cardRepository = cardRepository;
    this.boardService = boardService;
    this.movementService = movementService;
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
    card.setMovimentacao(new ArrayList<>());

    Movement movement = movementService.registerEntry(card,null,
        initialColumn.getTipo());
    card.getMovimentacao().add(movement);

    return cardRepository.save(card);
  }

  public Card findCardById(Long cardId) throws CardNotFoundException {
    return cardRepository.findById(cardId).orElseThrow(CardNotFoundException::new);
  }

  public Card moveToNextColumn(Long cardId) throws CardNotFoundException, MovementNotFoundException {
    Card card = findCardById(cardId);

    if (card.isBloqueado()) {
      throw new IllegalStateException("Card está bloqueado e não pode ser movido.");
    }

    Column atual = card.getColumn();
    Board board = atual.getBoard();

    List<Column> ordenadas = board.getColunas().stream()
        .sorted(Comparator.comparingInt(Column::getOrdem))
        .toList();

    int indexAtual = ordenadas.indexOf(atual);

    if (indexAtual == -1 || indexAtual + 1 >= ordenadas.size()) {
      throw new IllegalStateException("Card já está na última coluna ou ordem inválida.");
    }

    Column proxima = ordenadas.get(indexAtual + 1);

    if (proxima.getTipo() == CANCELAMENTO) {
      throw new IllegalStateException(
          "Não é possível mover diretamente para a coluna de cancelamento."
      );
    }

    // Registra saída da coluna atual
    movementService.registerExit(card);

    // Atualiza coluna
    card.setColumn(proxima);

    // Registra entrada na nova coluna
    Movement entrada = movementService.registerEntry(card, atual.getTipo(), proxima.getTipo());
    card.getMovimentacao().add(entrada);

    return cardRepository.save(card);
  }

  public void cancelCard(Long cardId) throws CardNotFoundException, MovementNotFoundException {
    Card card = findCardById(cardId);

    Column colunaAtual = card.getColumn();

    Column colunaCancelamento = colunaAtual.getBoard().getColunas()
        .stream()
        .filter(c -> c.getTipo() == CANCELAMENTO)
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Coluna de cancelamento não encontrada"));

    // Registra saída da coluna atual
    movementService.registerExit(card);

    // Altera a coluna do card
    card.setColumn(colunaCancelamento);

    // Registra entrada na coluna de cancelamento
    Movement movimentoCancelado = movementService.registerEntry(card, colunaAtual.getTipo(),
        colunaCancelamento.getTipo());
    card.getMovimentacao().add(movimentoCancelado);

    cardRepository.save(card);
  }

  public void blockCard(Long cardId, String motive) throws CardNotFoundException {
    Card card = findCardById(cardId);
    card.setBloqueado(true);

    cardRepository.save(card);
  }

  public void unlockCard(Long unlockId) throws CardNotFoundException {
    Card card = findCardById(unlockId);
    card.setBloqueado(false);

    cardRepository.save(card);
  }
}
