package com.project.task_board.dto;

import com.project.task_board.entity.Card;
import java.time.LocalDate;
import java.util.List;

public record CardDto(
    Long id,
    String titulo,
    String descricao,
    boolean bloqueado,
    String motivoBloqueio,
    LocalDate dataCriacao) {
  public static CardDto fromEntity(Card card) {
    return new CardDto(card.getId(),
        card.getTitulo(),
        card.getDescricao(),
        card.isBloqueado(),
        card.getMotivoBloqueio(),
        card.getDataCriacao()
    );
  }

  public static List<CardDto> fromEntityList(List<Card> cards) {
    return cards.stream().map(CardDto::fromEntity).toList();
  }
}
