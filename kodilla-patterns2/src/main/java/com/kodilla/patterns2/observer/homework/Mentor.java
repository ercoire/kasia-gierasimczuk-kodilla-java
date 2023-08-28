package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(ExerciseList exerciseList) {
        System.out.println(name + ": New exercises to check for " + exerciseList.getName()
        + "\n" + "total: " + exerciseList.getItems().size() + " exercises");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
