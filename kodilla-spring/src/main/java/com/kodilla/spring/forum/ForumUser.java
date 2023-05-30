package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {

    String userName;


    private ForumUser() {
        userName = "John Smith";
    }

}
