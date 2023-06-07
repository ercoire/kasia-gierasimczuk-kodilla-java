package com.kodilla.patterns.prototype;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BoardTestSuite {

    @Test
    void testToString() {
        //Given
        //creating the TasksList for todos
        TasksList listToDo = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number " + n)));

        //creating the TasksList for tasks in progress
        TasksList listInProgress = new TasksList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number " + n)));

        //creating the TasksList for done tasks
        TasksList listDone = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number " + n)));

        //creating the board and assigning the lists
        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);
        System.out.println(board);

        //making a shallow clone of object board
        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(board);
        System.out.println(clonedBoard);

        //making a deep copy of object board
        Board deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        board.getLists().remove(listToDo);

        //Then
        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedBoard);
        assertEquals(2, board.getLists().size());
        assertEquals(2, clonedBoard.getLists().size());
        assertEquals(3, deepClonedBoard.getLists().size());
        assertEquals(clonedBoard.getLists(), board.getLists());
        assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }
}
