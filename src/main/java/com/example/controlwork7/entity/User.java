package com.example.controlwork7.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
}
