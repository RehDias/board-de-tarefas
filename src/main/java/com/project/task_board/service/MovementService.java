package com.project.task_board.service;

import com.project.task_board.entity.Card;
import com.project.task_board.entity.Column;
import com.project.task_board.entity.Movement;
import com.project.task_board.repository.MovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementService {
  private final MovementRepository movementRepository;

  public MovementService(MovementRepository movementRepository) {
    this.movementRepository = movementRepository;
  }

  public Movement creteMovement(Card card, Column column) {

  }


}
