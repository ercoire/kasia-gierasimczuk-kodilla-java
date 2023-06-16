package com.kodilla.hibernate.tasklist.dao;


import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: exercise 17.2";

    @Test
    void findByListName() {

        //Given
        TaskList taskList = new TaskList("NEW_LIST", DESCRIPTION);
        taskListDao.save(taskList);
        String checkName = taskList.getListName();

        //When
        List<TaskList> readName = taskListDao.findByListName(checkName);

        //Then
        assertEquals("NEW_LIST", readName.get(0).getListName());

        //CleanUp
        int id = readName.get(0).getId();
        taskListDao.deleteById(id);
    }
}

