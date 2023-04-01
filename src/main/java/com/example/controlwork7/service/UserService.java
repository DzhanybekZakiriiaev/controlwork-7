package com.example.controlwork7.service;

import com.example.controlwork7.dao.UserDAO;
import com.example.controlwork7.dto.RegisterDTO;
import com.example.controlwork7.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public boolean existsByEmail(String email) {
        return userDAO.existsByEmail(email);
    }

    public void registerUser(RegisterDTO registerDTO) {
        userDAO.registerUser(registerDTO);
    }

    public List<User> getByEmail(String email){
        return userDAO.getByEmail(email);
    }
}
