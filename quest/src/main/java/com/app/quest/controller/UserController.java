package com.app.quest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.quest.entity.User;
import com.app.quest.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userSercive;

    public UserController(UserService userSercive) {
        this.userSercive = userSercive;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
       return ResponseEntity.ok(userSercive.getAllUsers());
    }

    @PostMapping
    public User creatUser(@RequestBody User user){
       return userSercive.creatUser(user);    

    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userID){
       return userSercive.getUserById(userID);
    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
        
        return userSercive.updateOneUser(userId,newUser);
    }

    @DeleteMapping("/{userId}")
    public Boolean deleteUserById(@PathVariable Long userId){

        return userSercive.deleteUserById(userId);
    }

}
