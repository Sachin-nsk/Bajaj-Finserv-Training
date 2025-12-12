package com.example.day2.service;

import com.example.day2.dto.UserRequestDTO;
import com.example.day2.entity.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();
    private long id = 1;

    public User createUser(UserRequestDTO request) {
        User newUser = new User(id++, request.getName(), request.getEmail());
        userList.add(newUser);
        return newUser;
    }

    public boolean deleteUser(Long id) {
        return userList.removeIf(user -> user.getId().equals(id));
    }   
    
    public User updateUser(Long id, UserRequestDTO updatedData) {
        for(User user: userList) {
            if(user.getId().equals(id)) {
                user.setName(updatedData.getName());
                user.setEmail(updatedData.getEmail());
                return user;
            }
        }
        return null;
    }

    public User getUser(Long id) {
        for(User user: userList) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userList;
    }

}
