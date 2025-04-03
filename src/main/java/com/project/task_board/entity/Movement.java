package com.project.task_board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Movement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime dataHoraEntrada;
  private LocalDateTime dataHoraSaida;
  private Column colunaAnterior;
  private Column colunaAtual;

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

  public Column getColunaAnterior() {
    return colunaAnterior;
  }

  public void setColunaAnterior(Column colunaAnterior) {
    this.colunaAnterior = colunaAnterior;
  }

  public Column getColunaAtual() {
    return colunaAtual;
  }

  public void setColunaAtual(Column colunaAtual) {
    this.colunaAtual = colunaAtual;
  }
}
