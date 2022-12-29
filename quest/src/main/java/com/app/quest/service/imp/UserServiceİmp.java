package com.app.quest.service.imp;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.quest.entity.User;
import com.app.quest.repos.UserRepository;
import com.app.quest.service.UserService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceİmp  implements UserService{
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public User creatUser(User user) {
       return userRepository.save(user);
        
    }

    @Override
    public User getUserById(Long userID) {
        Optional<User> user = userRepository.findById(userID);
        if(user.isPresent()){
            return user.get();
        }

        return null;
    }

    @Override
    public User updateOneUser(Long userId,User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            User user2 = user.get();
            user2.setPassword(newUser.getPassword());
            user2.setUsername(newUser.getUsername());
            userRepository.save(user2);
            return user2;
        }

        return null;
    }

    @Override
    public Boolean deleteUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
    


    

    

}

