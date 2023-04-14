package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

   private final int userID;
   private final String userName;
   private final char gender;
   private final LocalDate birthDate;
   private final int postCount;

   public ForumUser(int userID, String userName, char gender, int yearOfBirth,
                    int monthOfBirth, int dayOfBirth, int postCount) {
      this.userID = userID;
      this.userName = userName;
      this.gender = gender;
      this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
      this.postCount = postCount;
   }


   public int getUserID() {
      return userID;
   }

   public String getUserName() {
      return userName;
   }

   public char getGender() {
      return gender;
   }

   public LocalDate getBirthDate() {
      return birthDate;
   }

   public int getPostCount() {
      return postCount;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ForumUser forumUser = (ForumUser) o;

      if (userID != forumUser.userID) return false;
      if (gender != forumUser.gender) return false;
      if (postCount != forumUser.postCount) return false;
      if (!userName.equals(forumUser.userName)) return false;
      return birthDate.equals(forumUser.birthDate);
   }

   @Override
   public int hashCode() {
      int result = userID;
      result = 31 * result + userName.hashCode();
      result = 31 * result + (int) gender;
      result = 31 * result + birthDate.hashCode();
      result = 31 * result + postCount;
      return result;
   }

   @Override
   public String toString() {
      return "ForumUser{" +
            "userID=" + userID +
            ", userName='" + userName + '\'' +
            ", gender=" + gender +
            ", birthDate=" + birthDate +
            ", postCount=" + postCount +
            '}';
   }
}
