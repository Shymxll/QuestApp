package com.app.quest.service;

import java.util.List;

import com.app.quest.entity.User;



public interface UserService {

    List<User> getAllUsers();

    User creatUser(User user);

    User getUserById(Long userID);

    User updateOneUser(Long userId,User user);

    Boolean deleteUserById(Long userId);
    
}
