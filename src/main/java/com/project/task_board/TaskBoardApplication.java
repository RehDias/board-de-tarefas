package com.project.task_board;

import com.project.task_board.service.exceptions.BoardNotFoundException;
import com.project.task_board.utils.MenuSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskBoardApplication implements CommandLineRunner {
	@Autowired
	private MenuSystem menuSystem;

	public static void main(String[] args) {
		SpringApplication.run(TaskBoardApplication.class, args);
	}

	@Override
	public void run(String... args) throws InterruptedException, BoardNotFoundException {
		menuSystem.start();
	}

}
