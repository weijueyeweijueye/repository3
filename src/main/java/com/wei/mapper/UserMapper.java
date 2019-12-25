package com.wei.mapper;

import com.wei.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
   User selectUserByIdAndPasswordAndUsername(int id, String username, String password);

   User selectUserByPasswordAndUsername(@Param("username") String username, @Param("password") String password);

   int insertUserByUser(@Param("user") User user);
   int a=10;

   int insertUserByUsers(@Param("user1") User user1, @Param("user2") User user2);
   int insertUserByUsers2(User user1, User user2);
}
