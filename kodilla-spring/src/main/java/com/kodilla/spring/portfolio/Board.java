package com.kodilla.spring.portfolio;

public class Board {

    TaskList toDoList;
    TaskList inProgressList;
    TaskList doneList;

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    public Board() {
        doneList = new TaskList();
        inProgressList = new TaskList();
        toDoList = new TaskList();
    }

    public void addTask(String taskName) {
        getDoneList().getTasks().add(taskName);
        getInProgressList().getTasks().add(taskName);
        getToDoList().getTasks().add(taskName);
        System.out.println(taskName + " has been added to the task lists.");
    }
}
