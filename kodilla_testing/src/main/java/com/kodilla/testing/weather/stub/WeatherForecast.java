package com.kodilla.testing.weather.stub;

import java.util.*;
import java.lang.*;

public class WeatherForecast {
   private Temperatures temperatures;

   public WeatherForecast(Temperatures temperatures) {
      this.temperatures = temperatures;
   }


   public Map<String, Double> calculateForecast() {
      Map<String, Double> resultMap = new HashMap<>();

      for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
         // adding 1 celsius degree to current value
         // as a temporary weather forecast
         resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
      }
      return resultMap;
   }
//Napisz metodę (i test do niej), która na podstawie danych z interfejsu obliczy średnią temperaturę,

   public double calculateAverageTemperature() {
      double sum = 0;
      double avgTemperature;
      for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
         sum += temperature.getValue();
      }
      avgTemperature = sum / temperatures.getTemperatures().size();
      return avgTemperature;
   }
//Napisz metodę (i test do niej), która na podstawie danych z interfejsu obliczy medianę temperatur.

   public double calculateMedianTemperature() {
      double medianTemperature;
      int size = temperatures.getTemperatures().size();
      ArrayList <Double> array = new ArrayList<>();
      for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
         array.add(temperature.getValue());
      }
      Collections.sort(array);
      if (size == 0) {
         medianTemperature = 0;
      } else if (size %2 == 0) {
         int middle = size/2;
         double oneLeftFromMiddle = array.get(middle-1);
         double rightFromMiddle = array.get(middle);
         medianTemperature = (oneLeftFromMiddle + rightFromMiddle)/2;
      } else {
         int middleIndex = size/2;
         medianTemperature = array.get(middleIndex);
      }
      return medianTemperature;
   }
}
