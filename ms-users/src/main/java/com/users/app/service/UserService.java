package com.users.app.service;

import com.users.app.models.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> findAllUsers();
    Optional<User> findById(Long id);
    Optional<User> findByUserName(String username);
    User saveUser(User user);
    void deleteUser(Long id);
    Optional<User> updateUser(User user, Long id);
}
