package com.anhngo.shopthueaccanhngo.controllers;

import com.anhngo.shopthueaccanhngo.dto.UserGET;
import com.anhngo.shopthueaccanhngo.dto.UserPOST;
import com.anhngo.shopthueaccanhngo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserAPI {
    private UserService userService;

    @Autowired
    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserGET> index() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserGET show(@PathVariable(name = "id") String id) {
        return userService.findByIdAPI(id);
    }

    @PostMapping
    public UserPOST create(@RequestBody UserPOST userPOST) {
        return userService.saveAPI(userPOST);
    }

    @PutMapping("/{id}")
    public UserPOST update(@PathVariable(name = "id") String id, @RequestBody UserPOST userPOST) {
        return userService.updateAPI(id, userPOST);
    }
}
