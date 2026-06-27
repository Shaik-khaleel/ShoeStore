package com.shoes.dao;

import com.shoes.model.User;

public interface UserDAO {

    // Register User
    boolean registerUser(User user);

    // Login User
    User loginUser(String email, String password);

    // Get User By ID
    User getUserById(int id);

    // Update User
    boolean updateUser(User user);
}