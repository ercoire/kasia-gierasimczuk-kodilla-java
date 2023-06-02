package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {


    @Test
    void shouldGetLastLog() {
        //Given
        Logger logger = Logger.LOGFILE;
        logger.log("20230602_log");
        //When
        String expected = logger.getLastLog();

        //Then
        assertEquals(expected, "20230602_log");
    }


}
