package com.anhngo.shopthueaccanhngo.services;

import com.anhngo.shopthueaccanhngo.dto.UserGET;
import com.anhngo.shopthueaccanhngo.dto.UserPOST;
import com.anhngo.shopthueaccanhngo.entities.User;
import com.anhngo.shopthueaccanhngo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User findById(String username) {
        return userRepo.findById(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<UserGET> findAll() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(UserGET::new)
                .collect(Collectors.toList());
    }

    public UserGET findByIdAPI(String id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserGET(user);
    }

    public UserPOST saveAPI(UserPOST userPOST) {
        if (userRepo.existsById(userPOST.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(userPOST.getUsername());
        user.setPassword(userPOST.getPassword());
        user.setEnabled(userPOST.getEnabled());
        user.setPhone(userPOST.getPhone());
        user.setEmail(userPOST.getEmail());
        user.setFullName(userPOST.getFullName());
        user.setNgayTao(userPOST.getNgayTao());
        user.setAddress(userPOST.getAddress());
        user.setHinhAnh(userPOST.getHinhAnh());
        user.setMoney(userPOST.getMoney());
        userRepo.save(user);
        return new UserPOST(user);
    }

    public UserPOST updateAPI(String id, UserPOST userPOST) {
        return userRepo.findById(id)
                .map(user -> {
                    user.setUsername(userPOST.getUsername());
                    user.setPassword(userPOST.getPassword());
                    user.setEnabled(userPOST.getEnabled());
                    user.setPhone(userPOST.getPhone());
                    user.setEmail(userPOST.getEmail());
                    user.setFullName(userPOST.getFullName());
                    user.setNgayTao(userPOST.getNgayTao());
                    user.setAddress(userPOST.getAddress());
                    user.setHinhAnh(userPOST.getHinhAnh());
                    user.setMoney(userPOST.getMoney());
                    userRepo.save(user);
                    return new UserPOST(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
