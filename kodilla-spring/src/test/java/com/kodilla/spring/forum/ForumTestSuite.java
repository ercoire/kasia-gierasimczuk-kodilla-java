package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumTestSuite {

    @Test
    void getUserName(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.forum");
        ForumUser forumUser = context.getBean(ForumUser.class);

        //When
        String name = forumUser.userName;

        //Then
        assertEquals("John Smith", name);
    }

}
