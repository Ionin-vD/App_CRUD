package com.crud.democrud.db.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository userRepository;

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public AppUser createUser(AppUser user) {
        return userRepository.save(user);
    }

    public AppUser updateUser(AppUser user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}