package com.kodilla.spring.portfolio;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When & Then

       board.addTask("new task");

        System.out.println("Current state of inProgress list: " + board.inProgressList.getTasks());
        System.out.println("Current state of toDo list: " + board.toDoList.getTasks());
        System.out.println("Current state of done list: " + board.doneList.getTasks());

    }


}
