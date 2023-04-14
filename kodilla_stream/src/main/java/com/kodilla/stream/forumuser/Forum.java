package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {

   private final List <ForumUser> userList = new ArrayList<>();

   public List<ForumUser> getUserList() {
      userList.add(new ForumUser(101, "blighterfornost", 'M', 1995, 12, 27, 10 ));
      userList.add(new ForumUser(201, "mallorndoylt", 'F', 2001, 10, 9, 2 ));
      userList.add(new ForumUser(202, "gollumhardtofind", 'F', 1992, 2,13, 0 ));
      userList.add(new ForumUser(301, "homevalinor", 'M', 1999, 6, 4, 23 ));
      userList.add(new ForumUser(302, "lamentthingol", 'M', 2002, 2,2, 0 ));
      userList.add(new ForumUser(303, "gamgeefrustrated", 'F', 1991, 12, 2, 1 ));
      userList.add(new ForumUser(401, "trollsfunction", 'M', 1989, 9,19, 12 ));
      userList.add(new ForumUser(402, "ornateoin", 'M', 2003, 4, 15, 10 ));
      userList.add(new ForumUser(403, "streamerorthanc", 'F', 1998, 11, 7, 3 ));
      return userList;
   }


}
