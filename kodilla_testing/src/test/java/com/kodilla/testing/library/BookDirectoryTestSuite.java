package com.kodilla.testing.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {
   @Mock
   private LibraryDatabase libraryDatabaseMock;

   @Nested
   @DisplayName("Tests for books with title fragment")
   class TestBooksWithCondition {

      @Test
      void testListBooksWithConditionsReturnList() {
         // Given
         BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);                  // [3]
         List<Book> resultListOfBooks = new ArrayList<>();                                // [4]
         Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
         Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
         Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
         Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
         resultListOfBooks.add(book1);                                                    // [9]
         resultListOfBooks.add(book2);                                                    // [10]
         resultListOfBooks.add(book3);                                                    // [11]
         resultListOfBooks.add(book4);                                                    // [12]
         when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);// [13]

         // When
         List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");        // [14]

         // Then
         assertEquals(4, theListOfBooks.size());
      }

      //...
      private List<Book> generateListOfNBooks(int booksQuantity) {
         List<Book> resultList = new ArrayList<>();
         for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
         }
         return resultList;
      }

      // ...
      @Test
      void testListBooksWithConditionMoreThan20() {
         BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);                              // [1]
         List<Book> resultListOf0Books = new ArrayList<>();                                           // [2]
         List<Book> resultListOf15Books = generateListOfNBooks(15);                       // [3]
         List<Book> resultListOf40Books = generateListOfNBooks(40);                       // [4]
         when(libraryDatabaseMock.listBooksWithCondition(anyString()))                                // [5]
               .thenReturn(resultListOf15Books);                                                      // [6]
         when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))                    // [7]
               .thenReturn(resultListOf0Books);                                                       // [8]
         when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))                   // [9]
               .thenReturn(resultListOf40Books);                                                      // [10]

         // When
         List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");    // [11]
         List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");   // [12]
         List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");  // [13]
         // Then

         assertEquals(0, theListOfBooks0.size());                                         // [14]
         assertEquals(15, theListOfBooks15.size());                                       // [15]
         assertEquals(0, theListOfBooks40.size());                                        // [16]
      }

      @Test
      void testListBooksWithConditionFragmentShorterThan3() {
         // Given
         LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);            // [2]
         BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);               // [3]

         // When
         List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");       // [4]

         // Then
         assertEquals(0, theListOfBooks10.size());                                     // [5]
         verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());    // [6]
      }
   }

   @Nested
   @DisplayName("Tests for books borrowed by user")
   class TestBooksInHandsOf {

      @Test
      void shouldReturnZeroForNoBorrowedBooks() {

         // Given
         List<Book> borrowedBooks = new ArrayList<>();
         BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
         LibraryUser testUser = new LibraryUser();
         when(libraryDatabaseMock.listBooksInHandsOf(testUser)).thenReturn(borrowedBooks);

         //When
         List<Book> result = bookLibrary.listBooksInHandsOf(testUser);

         //Then
         assertEquals(0, result.size());
      }

      @Test
      void shouldReturn1When1BookBorrowed() {
         //Given
         List<Book> borrowedBooks = new ArrayList<>();
         BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
         LibraryUser testUser = new LibraryUser();
         Book book1 = new Book("Title1", "Author1", 2016);
         borrowedBooks.add(book1);
         when(libraryDatabaseMock.listBooksInHandsOf(testUser)).thenReturn(borrowedBooks);

         //When
         List<Book> result = bookLibrary.listBooksInHandsOf(testUser);

         //Then
         assertEquals(1, result.size());
      }

      @Test
      void shouldReturn5When5BooksBorrowed() {

         //Given
         BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
         LibraryUser testUser = new LibraryUser();
         List<Book> borrowedBooks = new ArrayList<>();

         Book book1 = new Book("Title1", "Author1", 2008);
         Book book2 = new Book("Title2", "Author2", 2012);
         Book book3 = new Book("Title3", "Author3", 2016);
         Book book4 = new Book("Title4", "Author4", 2010);
         Book book5 = new Book("Title5", "Author5", 2015);
         borrowedBooks.add(book1);
         borrowedBooks.add(book2);
         borrowedBooks.add(book3);
         borrowedBooks.add(book4);
         borrowedBooks.add(book5);
         when(libraryDatabaseMock.listBooksInHandsOf(testUser)).thenReturn(borrowedBooks);

         //When
         List<Book> result = bookLibrary.listBooksInHandsOf(testUser);

         //Then
         assertEquals(5, result.size());
      }

   }
}