package com.project.task_board.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
  private List<Column> colunas;

  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
  private List<Report> reports;

  private String nome;

  public Board() {
  }

  public Board(String nome, List<Column> colunas, List<Report> reports) {
    this.nome = nome;
    this.colunas = colunas;
    this.reports = reports;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Column> getColunas() {
    return colunas;
  }

  public void setColunas(List<Column> colunas) {
    this.colunas = colunas;
  }

  public List<Report> getReports() {
    return reports;
  }

  public void setReports(List<Report> reports) {
    this.reports = reports;
  }
}
