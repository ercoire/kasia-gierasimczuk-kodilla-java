package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {
   @Test
   void testAddTaskList() {
      //Given
      Board project = prepareTestData();
      //When

      //Then
      assertEquals(3, project.getTaskLists().size());
   }

   private Board prepareTestData() {
      //users
      User user1 = new User("developer1", "John Smith");
      User user2 = new User("projectmanager1", "Nina White");
      User user3 = new User("developer2", "Emilia Stephanson");
      User user4 = new User("developer3", "Konrad Bridge");

      //tasks
      Task task1 = new Task("Microservice for taking temperature",
            "Write and test the microservice taking\n" +
                  "the temperature from external service",
            user1,
            user2,
            LocalDate.now().minusDays(20),
            LocalDate.now().plusDays(30));
      Task task2 = new Task("HQLs for analysis",
            "Prepare some HQL queries for analysis",
            user1,
            user2,
            LocalDate.now().minusDays(20),
            LocalDate.now().minusDays(5));
      Task task3 = new Task("Temperatures entity",
            "Prepare entity for temperatures",
            user3,
            user2,
            LocalDate.now().minusDays(20),
            LocalDate.now().plusDays(15));
      Task task4 = new Task("Own logger",
            "Refactor company logger to meet our needs",
            user3,
            user2,
            LocalDate.now().minusDays(10),
            LocalDate.now().plusDays(25));
      Task task5 = new Task("Optimize searching",
            "Archive data searching has to be optimized",
            user4,
            user2,
            LocalDate.now(),
            LocalDate.now().plusDays(5));
      Task task6 = new Task("Use Streams",
            "use Streams rather than for-loops in predictions",
            user4,
            user2,
            LocalDate.now().minusDays(15),
            LocalDate.now().minusDays(2));

      //taskLists
      TaskList taskListToDo = new TaskList("To do");
      taskListToDo.addTask(task1);
      taskListToDo.addTask(task3);
      TaskList taskListInProgress = new TaskList("In progress");
      taskListInProgress.addTask(task5);
      taskListInProgress.addTask(task4);
      taskListInProgress.addTask(task2);
      TaskList taskListDone = new TaskList("Done");
      taskListDone.addTask(task6);

      //board
      Board project = new Board("Project Weather Prediction");
      project.addTaskList(taskListToDo);
      project.addTaskList(taskListInProgress);
      project.addTaskList(taskListDone);
      return project;
   }

   @Test
   void testAddTaskListFindUsersTasks() {
      //Given
      Board project = prepareTestData();

      //When
      User user = new User("developer1", "John Smith");     // [1]
      List<Task> tasks = project.getTaskLists().stream()    // [2]
            .flatMap(l -> l.getTasks().stream())               // [3]
            .filter(t -> t.getAssignedUser().equals(user))     // [4]
            .collect(toList());                                // [5]

      //Then
      assertEquals(2, tasks.size());
      assertEquals(user, tasks.get(0).getAssignedUser());
      assertEquals(user, tasks.get(1).getAssignedUser());
   }

   @Test
   void testAddTaskListFindOutdatedTasks() {
      //Given
      Board project = prepareTestData();

      //When
      List<TaskList> undoneTasks = new ArrayList<>();             // [1]
      undoneTasks.add(new TaskList("To do"));                     // [2]
      undoneTasks.add(new TaskList("In progress"));               // [3]
      List<Task> tasks = project.getTaskLists().stream()          // [4]
            .filter(undoneTasks::contains)                           // [5]
            .flatMap(tl -> tl.getTasks().stream())                   // [6]
            .filter(t -> t.getDeadline().isBefore(LocalDate.now()))  // [7]
            .collect(toList());                                      // [8]

      //Then
      assertEquals(1, tasks.size());                              // [9]
      assertEquals("HQLs for analysis", tasks.get(0).getTitle());
   }

   @Test
   void testAddTaskListFindLongTasks() {
      //Given
      Board project = prepareTestData();

      //When
      List<TaskList> inProgressTasks = new ArrayList<>();               // [1]
      inProgressTasks.add(new TaskList("In progress"));                 // [2]
      long longTasks = project.getTaskLists().stream()                  // [3]
            .filter(inProgressTasks::contains)                             // [4]
            .flatMap(tl -> tl.getTasks().stream())                         // [5]
            .map(Task::getCreated)                                         // [6]
            .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)  // [7]
            .count();                                                      // [8]

      //Then
      assertEquals(2, longTasks);                                       // [9]
   }

   @Test
   void testAddTaskListAverageWorkingOnTask() {

      //Given
      Board project = prepareTestData();

      //When
      List<TaskList> inProgress = new ArrayList<>();
      inProgress.add(new TaskList("In progress"));
      double averageDays = project.getTaskLists().stream()
            .filter(inProgress::contains)
            .flatMap(t -> t.getTasks().stream())
            .map(Task::getCreated)
            .mapToLong(taskCreationDate -> DAYS.between(taskCreationDate, LocalDate.now()))
            .average()
            .getAsDouble();


      //Then
      assertEquals(10, averageDays);

   }
}
