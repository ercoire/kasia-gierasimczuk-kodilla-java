package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        Book book1 = new Book("Victor Hugo", "Les Miserables", 1852,"393310728");
        Book book2 = new Book("Thomas Mann", "Buddebrooks", 1901, "908606273");
        Book book3 = new Book("William Makepeace", "Vanity Fair", 1847, "619913141");
        Book book4 = new Book("Eve Sutton", "My Cat Likes to Hide in Boxes", 1983, "1908606206");
        Book book5 = new Book("Mikhail Bulgakov", "The Master and Margarita", 1966, "912227731");
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        MedianAdapter testAdapter = new MedianAdapter();

        // When
        int median = testAdapter.publicationYearMedian(books);

        // Then
        Assertions.assertEquals(1901, median);
    }
}
