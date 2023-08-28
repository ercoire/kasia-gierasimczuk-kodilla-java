package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    public MedianAdapter() {
    }

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        //conversion Set<Book> to Map<BookSignature, Book>
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> mapOfBooks = new HashMap<>();
        for (Book book:bookSet) {
            com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book newBook =
                    new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(
                            book.getAuthor(),
                            book.getTitle(),
                            book.getPublicationYear()
                    );
            BookSignature newSignature = new BookSignature(book.getSignature());
            mapOfBooks.put(newSignature, newBook);
        }
        return medianPublicationYear(mapOfBooks);
    }
}
