package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Bean(name = "board")
    public Board getBoard(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        return new Board(toDoList, inProgressList, doneList);
    }

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList getDoneList() {
        return new TaskList();
    }

}
