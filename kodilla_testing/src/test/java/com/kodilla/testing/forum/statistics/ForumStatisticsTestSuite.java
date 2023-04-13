package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@DisplayName("Forum Test Statistics")
public class ForumStatisticsTestSuite {

   @Mock
   private Statistics statisticsMock;

   private StatisticsCalculations testCalculations;

   @BeforeEach
   void setup() {
      testCalculations = new StatisticsCalculations();
   }


   @Nested
   @DisplayName("Tests for posts")
   class TestsForPosts {
      @Test
      void shouldCalculateFor0PostsNumber() {

         //Given
         List<String> testUsers = new ArrayList<>();
         testUsers.add("user1");
         testUsers.add("user2");
         testUsers.add("user3");

         when(statisticsMock.postsCount()).thenReturn(0);
         when(statisticsMock.usersNames()).thenReturn(testUsers);
         when(statisticsMock.commentsCount()).thenReturn(5);

         //When
         testCalculations.calculateAdvStatistics(statisticsMock);

         //Then
         assertEquals(0, testCalculations.getPostNumber());
         assertEquals(0, testCalculations.getAvgPostPerUserCount());
         assertEquals(0, testCalculations.getAvgCommentPerPostCount());

      }

      @Test
      void shouldCalculateFor1000PostsNumber() {

         //Given
         List<String> testUsers = new ArrayList<>();
         testUsers.add("user1");
         testUsers.add("user2");
         testUsers.add("user3");
         testUsers.add("user4");

         when(statisticsMock.postsCount()).thenReturn(1000);
         when(statisticsMock.usersNames()).thenReturn(testUsers);
         when(statisticsMock.commentsCount()).thenReturn(2000);

         //When
         testCalculations.calculateAdvStatistics(statisticsMock);

         //Then
         assertEquals(1000, testCalculations.getPostNumber());
         assertEquals(250, testCalculations.getAvgPostPerUserCount());
         assertEquals(2, testCalculations.getAvgCommentPerPostCount());
      }
   }

   @Nested
   @DisplayName("Tests for comments")
   class TestsForComments {
      @Test
      void shouldCalculateFor0Comments() {

         //Given
         List<String> testUsers = new ArrayList<>();
         testUsers.add("user1");
         testUsers.add("user2");
         testUsers.add("user3");
         testUsers.add("user4");

         when(statisticsMock.commentsCount()).thenReturn(0);
         when(statisticsMock.usersNames()).thenReturn(testUsers);
         when(statisticsMock.postsCount()).thenReturn(5);

         //When
         testCalculations.calculateAdvStatistics(statisticsMock);

         //Then
         assertEquals(0, testCalculations.getCommentNumber());
         assertEquals(0, testCalculations.getAvgCommentPerUserCount());
         assertEquals(0, testCalculations.getAvgCommentPerPostCount());

      }

      @Test
      void shouldCalculateForCommentsLessThanPosts() {

         //Given
         when(statisticsMock.commentsCount()).thenReturn(300);
         when(statisticsMock.postsCount()).thenReturn(500);

         //When
         testCalculations.calculateAdvStatistics(statisticsMock);

         //Then
         assertTrue(testCalculations.getAvgCommentPerPostCount() < 1);
         assertTrue(testCalculations.getCommentNumber() < testCalculations.getPostNumber());

      }

      @Test
      void shouldCalculateForCommentsMoreThanPosts() {

         //Given
         when(statisticsMock.commentsCount()).thenReturn(200);
         when(statisticsMock.postsCount()).thenReturn(50);

         //When
         testCalculations.calculateAdvStatistics(statisticsMock);

         //Then
         assertTrue(testCalculations.getAvgCommentPerPostCount() > 1);
         assertTrue(testCalculations.getCommentNumber() > testCalculations.getPostNumber());
      }
   }

   @Nested
   @DisplayName("Tests for users")
   class TestsForUsers {
      @Test
      void shouldCalculateFor0Users() {

         //Given
         List<String> testUsers = new ArrayList<>();

         when(statisticsMock.usersNames()).thenReturn(testUsers);
         when(statisticsMock.postsCount()).thenReturn(2);
         when(statisticsMock.commentsCount()).thenReturn(2);

         //When
         testCalculations.calculateAdvStatistics(statisticsMock);

         //Then
         assertEquals(0, testCalculations.getUserNumber());
         assertEquals(0, testCalculations.getAvgPostPerUserCount());
         assertEquals(0, testCalculations.getAvgCommentPerUserCount());

      }

      @Test
      void shouldCalculateFor100Users() {

         //Given
         List<String> testUsers = new ArrayList<>();
            for (int i = 1; i < 101; i++) {
               testUsers.add("user"+i);
            }
         when(statisticsMock.usersNames()).thenReturn(testUsers);
         when(statisticsMock.postsCount()).thenReturn(20);
         when(statisticsMock.commentsCount()).thenReturn(50);

         //When
         testCalculations.calculateAdvStatistics(statisticsMock);

         //Then
         assertEquals(100, testCalculations.getUserNumber());
         assertEquals(0.2, testCalculations.getAvgPostPerUserCount());
         assertEquals(0.5, testCalculations.getAvgCommentPerUserCount());
      }

   }
}
