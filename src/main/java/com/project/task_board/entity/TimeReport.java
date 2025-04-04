package com.project.task_board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TimeReport {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "report_id", nullable = false)
  private Report report;

  private Card card;
  private Column colunaInicial;
  private Column colunaFinal;
  private Long tempoTotal;

  public TimeReport() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }

  public Column getColunaInicial() {
    return colunaInicial;
  }

  public void setColunaInicial(Column colunaInicial) {
    this.colunaInicial = colunaInicial;
  }

  public Column getColunaFinal() {
    return colunaFinal;
  }

  public void setColunaFinal(Column colunaFinal) {
    this.colunaFinal = colunaFinal;
  }

  public Long getTempoTotal() {
    return tempoTotal;
  }

  public void setTempoTotal(Long tempoTotal) {
    this.tempoTotal = tempoTotal;
  }

  public Report getReport() {
    return report;
  }

  public void setReport(Report report) {
    this.report = report;
  }
}
