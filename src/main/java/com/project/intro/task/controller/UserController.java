package com.project.intro.task.controller;

import com.project.intro.task.model.User;
import com.project.intro.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{email}")
    public User getUser(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/user/{email}")
    public void updateUser(@PathVariable String email){
         userService.delete(email);
    }


}
