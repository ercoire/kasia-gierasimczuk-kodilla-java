package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Library extends Prototype {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowClone() throws CloneNotSupportedException {
        return (Library) super.clone();
    }
/*
    public Library deepClone() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        /*  Board clonedBoard = super.clone();
        clonedBoard.lists = new HashSet<>();
        for (TasksList theList : lists) {
        TasksList clonedList = new TasksList(theList.getName());
        for (Task task : theList.getTasks()) {
            clonedList.getTasks().add(task);
        }
        clonedBoard.getLists().add(clonedList);
    }
        return clonedLibrary;
    }*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        if (!Objects.equals(name, library.name)) return false;
        return books.equals(library.books);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + books.hashCode();
        return result;
    }

    /* 5. Zmodyfikuj klasę Library tak, aby była zgodna ze wzorcem "Prototype".*/
}