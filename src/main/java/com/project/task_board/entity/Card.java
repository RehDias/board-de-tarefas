package com.project.task_board.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "column_id", nullable = false)
  private Column column;

  @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
  private List<Movement> movimentacao;

  private String titulo;
  private String descricao;
  private LocalDate dataCriacao;
  private boolean bloqueado;
  private String motivoBloqueio;
  private LocalDate dataBloqueio;
  private LocalDate dataDesbloqueio;
  private String motivoDesbloqueio;

  public Card() {
  }

  public Card(String titulo, String descricao) {
    this.titulo = titulo;
    this.descricao = descricao;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public boolean isBloqueado() {
    return bloqueado;
  }

  public void setBloqueado(boolean bloqueado) {
    this.bloqueado = bloqueado;
  }

  public String getMotivoBloqueio() {
    return motivoBloqueio;
  }

  public void setMotivoBloqueio(String motivoBloqueio) {
    this.motivoBloqueio = motivoBloqueio;
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

  public String getMotivoDesbloqueio() {
    return motivoDesbloqueio;
  }

  public void setMotivoDesbloqueio(String motivoDesbloqueio) {
    this.motivoDesbloqueio = motivoDesbloqueio;
  }

  public List<Movement> getMovimentacao() {
    return movimentacao;
  }

  public void setMovimentacao(List<Movement> movimentacao) {
    this.movimentacao = movimentacao;
  }

  public Column getColumn() {
    return column;
  }

  public void setColumn(Column column) {
    this.column = column;
  }
}
