package com.project.task_board.utils;

import com.project.task_board.dto.BoardDto;
import com.project.task_board.entity.Board;
import com.project.task_board.service.BoardService;
import com.project.task_board.service.exceptions.BoardNotFoundException;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuSystem {
  private final BoardService boardService;
  private Board currentBoard;

  @Autowired
  public MenuSystem(BoardService boardService) {
    this.boardService = boardService;
  }

  public Board getCurrentBoard() {
    return currentBoard;
  }

  public void setCurrentBoard(Board currentBoard) {
    this.currentBoard = currentBoard;
  }

  public void start() throws BoardNotFoundException, InterruptedException {
    Scanner scanner = new Scanner(System.in);

    while(true) {
      if (currentBoard == null) {
        showMainMenu(scanner);
      } else {
        showBoardMenu(scanner);
      }
    }
  }

  private void showMainMenu(Scanner scanner) throws BoardNotFoundException, InterruptedException {
    System.out.println("Bem vindo ao gerenciador de boards, escolha a opção desejada");
    System.out.println("1. Criar um novo Board");
    System.out.println("2. Mostrar todos os boards");
    System.out.println("3. Selecionar um board existente");
    System.out.println("4. Apagar um board");
    System.out.println("5. Sair");
    Thread.sleep(1000);

    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {
      case 1:
        System.out.print("Informe o nome do board: ");
        String name = scanner.nextLine();
        BoardDto boardCreated = BoardDto.fromEntity(boardService.createNewBoard(name));
        System.out.println(boardCreated);
        Thread.sleep(2000);
        showMainMenu(scanner);
        break;

      case 2:
        List<Board> boards = boardService.listBoards();
        System.out.println(boards.stream().map(BoardDto::fromEntity).toList());
        Thread.sleep(2000);
        showMainMenu(scanner);
        break;

      case 3:
        System.out.print("Informe o Id do board desejado: ");
        Long findBoardById = scanner.nextLong();
        Board board = boardService.findBoardById(findBoardById);
        setCurrentBoard(board);
        System.out.println("Direcionando para o menu do board solicitado...");
        Thread.sleep(2000);
        showBoardMenu(scanner);
        break;

      case 4:
        System.out.print("Informe o Id do board que deseja excluir: ");
        Long deleteBoardId = scanner.nextLong();
        boardService.deleteBoard(deleteBoardId);
        System.out.println("Board foi apagada com sucesso!");
        Thread.sleep(2000);
        showMainMenu(scanner);
        break;

      case 5:
        System.out.println("Saindo do programa, até mais!");
        System.exit(0);
        break;

      default:
        System.out.println("Opção inválida, escolha uma opção válida!");
        Thread.sleep(2000);
        showMainMenu(scanner);
        break;
    }
  }

  private void showBoardMenu(Scanner scanner) throws BoardNotFoundException, InterruptedException {
    System.out.println("Board: " + getCurrentBoard().getNome());
    System.out.println("1. Criar um novo card");
    System.out.println("2. Mover card existente");
    System.out.println("3. Cancelar um card");
    System.out.println("4. Bloquear um card");
    System.out.println("5. Desbloquear um card");
    System.out.println("6. Gerar um relatório de tempo dos cards");
    System.out.println("7. Gerar um relatório dos bloqueios");
    System.out.println("8. Encerrar card");
    Thread.sleep(1000);

    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {
      case 1:

      case 8:
        Thread.sleep(2000);
        showMainMenu(scanner);
        break;

      default:
        System.out.println("Opção inválida, escolha uma opção válida!");
        Thread.sleep(2000);
        showBoardMenu(scanner);
        break;
    }
  }
}
