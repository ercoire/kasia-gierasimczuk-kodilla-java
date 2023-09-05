package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("new Task To Do");
        board.getInProgressList().getTasks().add("new Task In Progress");
        board.getDoneList().getTasks().add("new Task Done");


        //Then
        Board test = context.getBean(Board.class);
        assertEquals(1, test.getToDoList().getTasks().size());
        assertEquals(1, test.getInProgressList().getTasks().size());
        assertEquals(1, test.getDoneList().getTasks().size());
    }

    /*
    @Test
    void testContext() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.portfolio");

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
*/

}
