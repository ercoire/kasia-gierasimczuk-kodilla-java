package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }


    public Library deepCopy() throws CloneNotSupportedException {
        Library deepClonedLibrary = super.clone();
        deepClonedLibrary.books = new HashSet<>();
        for (Book book : books) {
            Book clonedBooks = new Book(book.getAuthor(), book.getTitle(), book.getPublicationDate());
            deepClonedLibrary.getBooks().add(clonedBooks);
        }
        return deepClonedLibrary;
    }

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
        return Objects.hash(name, books);
    }



    /* 5. Zmodyfikuj klasę Library tak, aby była zgodna ze wzorcem "Prototype".*/
}