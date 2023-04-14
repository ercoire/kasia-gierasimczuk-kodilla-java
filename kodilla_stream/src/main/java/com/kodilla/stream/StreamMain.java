package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

   public static void main(String[] args) {

      Forum theForum = new Forum();
      Map<Integer, ForumUser> forumStream = theForum.getUserList().stream()
            .filter(forumUser -> forumUser.getBirthDate().getYear() <= 2003)
            .filter(forumUser -> forumUser.getGender() == 'M')
            .filter(forumUser -> forumUser.getPostCount() >= 1)
            .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

      System.out.println("# elements: " + forumStream.size());
      forumStream.entrySet().stream()
            .map(entry -> entry.getKey() + ": " + entry.getValue())
            .forEach(System.out::println);

   }

}

