package com.kodilla.patterns.factory.tasks;


public class TaskFactory {

    public static final String SHOPPING = "Shopping";
    public static final String PAINTING = "Painting";
    public static final String DRIVING = "Driving";

    public final Task makeTask(final String tasks ) {
        return switch (tasks) {
            case SHOPPING -> new ShoppingTask("Spending some money on things.", "groceries", 3);
            case PAINTING -> new PaintingTask("Creating art on canvas.", "orange", "sunset");
            case DRIVING -> new DrivingTask("Going on an adventure.", "woods", "mom's car");
            default -> null;
        };

    }
}
