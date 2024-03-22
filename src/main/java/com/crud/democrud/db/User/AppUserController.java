package com.crud.democrud.db.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {
    @Autowired
    private AppUserService userService;

    @GetMapping
    public List<AppUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return userService.createUser(user);
    }

    @PutMapping
    public AppUser updateUser(@RequestBody AppUser user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}
