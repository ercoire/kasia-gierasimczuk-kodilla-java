package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    String taskName;
    String color;
    String whatToPaint;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }


    @Override
    public String executeTask() {
        String message = "I'm making a piece of art!";
        System.out.println(message);
        return message;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return (!color.equals("red"));
    }
}
