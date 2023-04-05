package com.kodilla.testing.weather.mock;
import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

   @Mock
   private Temperatures temperaturesMock;
   @Test
   void testCalculateForecastWithMock() {
      //Given
      Map<String, Double> temperaturesMap = new HashMap<>();
      temperaturesMap.put("Rzeszow", 25.5);
      temperaturesMap.put("Krakow", 26.2);
      temperaturesMap.put("Wroclaw", 24.8);
      temperaturesMap.put("Warszawa", 25.2);
      temperaturesMap.put("Gdansk", 26.1);
      when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
      WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

      //When
      int quantityOfSensors = weatherForecast.calculateForecast().size();

      //Then
      Assertions.assertEquals(5, quantityOfSensors);

   }

//Napisz metodę (i test do niej), która na podstawie danych z interfejsu obliczy średnią temperaturę,
   @Test
   void shouldCalculateAverageTemperature(){
      //Given
      Map<String, Double> temperaturesMap = new HashMap<>();
      temperaturesMap.put("Rzeszow", 25.5);
      temperaturesMap.put("Krakow", 26.2);
      temperaturesMap.put("Wroclaw", 24.8);
      temperaturesMap.put("Poznan", 23.7);
      when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
      WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);


      //When
      double averageTemp = weatherForecast.calculateAverageTemperature();


      //Then
      Assertions.assertEquals(25.05, averageTemp);
   }

//Napisz metodę (i test do niej), która na podstawie danych z interfejsu obliczy medianę temperatur.
   @Test
   void shouldCalculateMedianTemperatureForEven(){
      //Given
      Map<String, Double> temperaturesMap = new HashMap<>();
      temperaturesMap.put("Krakow", 26.2);
      temperaturesMap.put("Wroclaw", 24.8);
      temperaturesMap.put("Poznan", 23.7);
      temperaturesMap.put("Warszawa", 25.1);

      when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
      WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);


      //When
      double medianTemp = weatherForecast.calculateMedianTemperature();


      //Then
      Assertions.assertEquals(24.95, medianTemp, 0.001 );
   }

   @Test
   void shouldCalculateMedianTemperatureForOdd(){
      //Given
      Map<String, Double> temperaturesMap = new HashMap<>();
      temperaturesMap.put("Krakow", 26.2);
      temperaturesMap.put("Wroclaw", 24.8);
      temperaturesMap.put("Olsztyn", 23.4);
      temperaturesMap.put("Poznan", 23.7);
      temperaturesMap.put("Warszawa", 25.1);

      when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
      WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);


      //When
      double medianTemp = weatherForecast.calculateMedianTemperature();


      //Then
      Assertions.assertEquals(24.8, medianTemp, 0.001 );
   }

}
