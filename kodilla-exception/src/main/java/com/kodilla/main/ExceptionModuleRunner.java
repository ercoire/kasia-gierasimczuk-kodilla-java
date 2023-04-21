package com.kodilla.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.IOException;

public class ExceptionModuleRunner {

   public static void main(String[] args) {
      FileReader fileReader = new FileReader();

      try {
         fileReader.readFile();
      } catch (FileReaderException e) {
         System.out.println("Problem while reading a file!");
      }

      try {
         fileReader.readFile("ames.txt");
      } catch (FileReaderException e) {
         System.out.println("Problem while reading a file!");
      }

   }


//8.1
//      FileReader fileReader = new FileReader();
//      fileReader.readFile();



}
