package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

   @Test
   void testReadFile() {
      // given
      FileReader fileReader = new FileReader();
      // when & then
      assertDoesNotThrow(() -> fileReader.readFile());
   }

   @Test
   void whenFileDoesntExistsReadFileShouldThrowException() {
      // given
      FileReader fileReader = new FileReader();
      String fileName = "nie_ma_takiego_pliku.txt";
      // when & then
      assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
   }

   @Test
   public void testReadFileWithName() {
      // given
      FileReader fileReader = new FileReader();
      // when & then
      assertAll(
            () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_takiego_pliku.txt")),
            () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
            () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
      );
   }
}
