package com.project.task_board.entity;

import com.project.task_board.utils.ColumnType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Column {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private ColumnType tipo;

  @OneToMany(mappedBy = "column", cascade = CascadeType.ALL)
  private List<Card> cards;

  @ManyToOne
  @JoinColumn(name = "board_id", nullable = false)
  private Board board;

  private String nome;
  private int ordem;

  public Column() {
  }

  public Column(String nome, ColumnType tipo, int ordem, Board board) {
    this.nome = nome;
    this.tipo = tipo;
    this.ordem = ordem;
    this.board = board;
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

  public ColumnType getTipo() {
    return tipo;
  }

  public void setTipo(ColumnType tipo) {
    this.tipo = tipo;
  }

  public int getOrdem() {
    return ordem;
  }

  public void setOrdem(int ordem) {
    this.ordem = ordem;
  }

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }
}
