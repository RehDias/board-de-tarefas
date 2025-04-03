package com.project.task_board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private List<Column> colunas;

  public Board() {
  }

  public Board(String nome, List<Column> colunas) {
    this.nome = nome;
    this.colunas = colunas;
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
}
