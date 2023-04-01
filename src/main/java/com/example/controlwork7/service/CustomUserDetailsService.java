package com.example.controlwork7.service;

import com.example.controlwork7.entity.CustomUserDetails;
import com.example.controlwork7.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
     
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (userService.getByEmail(email).size() == 0) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userService.getByEmail(email).get(0);
        return new CustomUserDetails(user);
    }
}