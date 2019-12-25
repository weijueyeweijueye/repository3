package com.wei.mapper;

import com.wei.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
   User selectUserByIdAndPasswordAndUsername(int id, String username, String password);

    int before=10;
   User selectUserByPasswordAndUsername(@Param("username") String username, @Param("password") String password);
      int after=20;
   int insertUserByUser(@Param("user") User user);
   int a=100;

   int insertUserByUsers(@Param("user1") User user1, @Param("user2") User user2);

    int b=1100; 
  int insertUserByUsers2(User user1, User user2);

}
