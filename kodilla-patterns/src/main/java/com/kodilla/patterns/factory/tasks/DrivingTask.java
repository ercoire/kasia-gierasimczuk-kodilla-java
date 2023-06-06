package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {

    String taskName;
    String where;
    String using;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String executeTask() {
        String message = "I'm trying to avoid traffic.";
        System.out.println(message);
        return message;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return (!where.equals("dentist") || using.equals("mom's car"));
    }
}
