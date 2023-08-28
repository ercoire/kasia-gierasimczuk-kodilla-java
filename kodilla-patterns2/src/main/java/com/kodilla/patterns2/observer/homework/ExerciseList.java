package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class ExerciseList implements Observable {
    private final List<Observer> observers;

    private final List<String> items;
    private final String name;

    public String getName() {
        return name;
    }

    public List<String> getItems() {
        return items;
    }

    public ExerciseList(String name) {
        observers = new ArrayList<>();
        items = new ArrayList<>();
        this.name = name;
    }

    public void addExercise(String exercise) {
        items.add(exercise);
        notifyObservers();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}