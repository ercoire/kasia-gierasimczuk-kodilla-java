package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies(){

        //Given
        User mitch = new Millenials("Mitch Stevens");
        User joseph = new YGeneration("Joseph Miller");
        User layla = new ZGeneration("Layla Johns");

        //When
        String mitchPosts = mitch.sharePost();
        System.out.println("Mitch says: " + mitchPosts);
        String josephPosts = joseph.sharePost();
        System.out.println("Joseph says: " + josephPosts);
        String laylaPosts = layla.sharePost();
        System.out.println("Layla says: " + laylaPosts);

        //Then
        assertEquals("Hello Facebook!", mitchPosts);
        assertEquals("Hello Twitter!", josephPosts);
        assertEquals("Hello Snapchat!", laylaPosts);
    }


    @Test
    void testIndividualSharingStrategy(){
        //Given
       User david = new Millenials("David Brown");

        //When
        String davidPosts = david.sharePost();
        System.out.println("David says: " + davidPosts);
        david.setSharingStrategy(new TwitterPublisher());
        davidPosts = david.sharePost();
        System.out.println("David now says: " + davidPosts);

        //Then
        assertEquals("Hello Twitter!", davidPosts);
    }


}
