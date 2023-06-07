package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTestSuite {

    @Test
    void testGetBooks(){
        //Given
        Library library = new Library("first");
        Book book1 = new Book("1984", "G. Orwell", LocalDate.of(1953, 7,2));
        Book book2 = new Book("Jane Eyre", "Ch. Bronte", LocalDate.of(1847, 4,3));
        Book book3 = new Book("Vanity Fair", "W. M. Thackeray", LocalDate.of(1949, 9,18));
        Book book4 = new Book("How to Lie with Statistics", "D. Huff", LocalDate.of(1996, 10,23));
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);



        //When


        //Then
        assertEquals(4, library.getBooks().size());
        assertTrue(library.getBooks().contains(book3));
    }

    /*DONE 4. W teście stwórz obiekt biblioteki oraz kilka obiektów książek i dodaj je do księgozbioru.*/

    /* 6. Zmodyfikuj test testGetBooks() w taki sposób, aby prezentował działanie shallowCopy() oraz deepCopy().*/
}
