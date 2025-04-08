package com.project.task_board.repository;

import com.project.task_board.entity.Card;
import com.project.task_board.entity.Movement;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

  Optional<Movement> findTopByCardOrderByDataHoraEntradaDesc(Card card);
  List<Movement> findByCardIdOrderByDataEntrada(Long cardId);
  List<Movement> findByCard_Coluna_Board_IdOrderByDataHoraEntrada(Long boardId);

  List<Movement> findByCardOrderByDataHoraEntrada(Card card);
}
