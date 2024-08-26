package com.anhngo.shopthueaccanhngo.services;

import com.anhngo.shopthueaccanhngo.entities.User;
import com.anhngo.shopthueaccanhngo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User findById(String username) {
        return userRepo.findById(username).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
