package com.project.task_board.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Report {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "board_id", nullable = false)
  private Board board;

  @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
  private List<TimeReport> tempos;

  @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
  private List<LockReport> bloqueios;

  public Report() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public List<TimeReport> getTempos() {
    return tempos;
  }

  public void setTempos(List<TimeReport> tempos) {
    this.tempos = tempos;
  }

  public List<LockReport> getBloqueios() {
    return bloqueios;
  }

  public void setBloqueios(List<LockReport> bloqueios) {
    this.bloqueios = bloqueios;
  }
}
