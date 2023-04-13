package com.kodilla.testing.forum.statistics;

public class StatisticsCalculations {
   private int userNumber;
   private int postNumber;
   private int commentNumber;
   private double avgPostPerUserCount;
   private double avgCommentPerUserCount;
   private double avgCommentPerPostCount;

   public void calculateAdvStatistics(Statistics statistics) {
      userNumber = statistics.usersNames().size();
      postNumber = statistics.postsCount();
      commentNumber = statistics.commentsCount();

      if (postNumber > 0 && userNumber > 0) {
         avgPostPerUserCount = (double)postNumber / (double)userNumber;
      } else {
         avgPostPerUserCount = 0;
      }
      if (commentNumber > 0 && userNumber > 0) {
         avgCommentPerUserCount = (double)commentNumber / (double)userNumber;
      } else {
         avgCommentPerUserCount = 0;
      }
      if (commentNumber > 0 && postNumber > 0) {
         avgCommentPerPostCount = (double)commentNumber / (double)postNumber;
      } else {
         avgCommentPerPostCount = 0;
      }

   }

   public void showStatistics() {
      System.out.println("Total user number is: " + userNumber);
      System.out.println("Total post number is: " + postNumber);
      System.out.println("Total comment number is: " + commentNumber);
      System.out.println("Average posts per user is: " + avgPostPerUserCount);
      System.out.println("Average comments per user is: " + avgCommentPerUserCount);
      System.out.println("Average comments per post is: " + avgCommentPerPostCount);
   }

   public int getUserNumber() {
      return userNumber;
   }

   public int getPostNumber() {
      return postNumber;
   }

   public int getCommentNumber() {
      return commentNumber;
   }

   public double getAvgPostPerUserCount() {
      return avgPostPerUserCount;
   }

   public double getAvgCommentPerUserCount() {
      return avgCommentPerUserCount;
   }

   public double getAvgCommentPerPostCount() {
      return avgCommentPerPostCount;
   }
}
