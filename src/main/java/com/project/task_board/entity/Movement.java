package com.project.task_board.entity;

import com.project.task_board.utils.ColumnType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Movement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "card_id", nullable = false)
  private Card card;

  private LocalDateTime dataHoraEntrada;
  private LocalDateTime dataHoraSaida;

  @Enumerated(EnumType.STRING)
  private ColumnType colunaAnterior;

  @Enumerated(EnumType.STRING)
  private ColumnType colunaAtual;

  public Movement() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getDataHoraEntrada() {
    return dataHoraEntrada;
  }

  public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
    this.dataHoraEntrada = dataHoraEntrada;
  }

  public LocalDateTime getDataHoraSaida() {
    return dataHoraSaida;
  }

  public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
    this.dataHoraSaida = dataHoraSaida;
  }

  public ColumnType getColunaAnterior() {
    return colunaAnterior;
  }

  public void setColunaAnterior(ColumnType colunaAnterior) {
    this.colunaAnterior = colunaAnterior;
  }

  public ColumnType getColunaAtual() {
    return colunaAtual;
  }

  public void setColunaAtual(ColumnType colunaAtual) {
    this.colunaAtual = colunaAtual;
  }

  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }
}
