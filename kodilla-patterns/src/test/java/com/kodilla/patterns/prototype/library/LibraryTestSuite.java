package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("first");
        Book book1 = new Book("1984", "G. Orwell", LocalDate.of(1953, 7, 2));
        Book book2 = new Book("Jane Eyre", "Ch. Bronte", LocalDate.of(1847, 4, 3));
        Book book3 = new Book("Vanity Fair", "W. M. Thackeray", LocalDate.of(1949, 9, 18));
        Book book4 = new Book("How to Lie with Statistics", "D. Huff", LocalDate.of(1996, 10, 23));
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);

        //making a shallow clone of object library
        Library shallowCopy = null;
        try {
            shallowCopy = library.shallowCopy();
            shallowCopy.setName("test shallow");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object library
        Library deepCopy = null;
        try {
            deepCopy = library.deepCopy();
            deepCopy.setName("test deep");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book4);

        //Then
        assertNotNull(shallowCopy);
        assertEquals(3, shallowCopy.getBooks().size());
        assertSame(library.getBooks(), shallowCopy.getBooks());
        assertFalse(shallowCopy.getBooks().contains(book4));
        assertNotNull(deepCopy);
        assertNotSame(library.getBooks(), deepCopy.getBooks());
        assertNotEquals(library.getBooks(), deepCopy.getBooks());
    }

}
