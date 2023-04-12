package com.kodilla.testing.library;
import java.util.Objects;

public class Book {
   String title;
   String author;
   int publicationYear;

   public Book(String title, String author, int publicationYear) {
      this.title = title;
      this.author = author;
      this.publicationYear = publicationYear;
   }

   public String getTitle() {
      return title;
   }

   public String getAuthor() {
      return author;
   }

   public int getPublicationYear() {
      return publicationYear;
   }

   public void setTitle(String title) {

      this.title = title;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public void setPublicationYear(int publicationYear) {
      this.publicationYear = publicationYear;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Book book = (Book) o;

      if (publicationYear != book.publicationYear) return false;
      if (!title.equals(book.title)) return false;
      return author.equals(book.author);
   }

   @Override
   public int hashCode() {
      return Objects.hash(title, author, publicationYear);
   }
}
