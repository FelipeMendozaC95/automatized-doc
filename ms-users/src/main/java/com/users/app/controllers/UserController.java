package com.users.app.controllers;


import com.users.app.models.user.User;
import com.users.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping(value = "/users/all")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/usser/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = service.findById(id);
        return user
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
