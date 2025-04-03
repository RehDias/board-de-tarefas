package com.project.task_board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class LockReport {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "report_id", nullable = false)
  private Report report;

  private Card card;
  private LocalDate dataBloqueio;
  private LocalDate dataDesbloqueio;
  private String motivoBloqueio;
  private Long tempoBloqueado;

  public LockReport() {
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

  public LocalDate getDataBloqueio() {
    return dataBloqueio;
  }

  public void setDataBloqueio(LocalDate dataBloqueio) {
    this.dataBloqueio = dataBloqueio;
  }

  public LocalDate getDataDesbloqueio() {
    return dataDesbloqueio;
  }

  public void setDataDesbloqueio(LocalDate dataDesbloqueio) {
    this.dataDesbloqueio = dataDesbloqueio;
  }

  public String getMotivoBloqueio() {
    return motivoBloqueio;
  }

  public void setMotivoBloqueio(String motivoBloqueio) {
    this.motivoBloqueio = motivoBloqueio;
  }

  public Long getTempoBloqueado() {
    return tempoBloqueado;
  }

  public void setTempoBloqueado(Long tempoBloqueado) {
    this.tempoBloqueado = tempoBloqueado;
  }

  public Report getReport() {
    return report;
  }

  public void setReport(Report report) {
    this.report = report;
  }
}
