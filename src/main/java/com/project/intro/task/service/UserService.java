package com.project.intro.task.service;

import com.project.intro.task.dao.UserRepository;
import com.project.intro.task.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        log.info("Save user " + user);
        return userRepository.save(user);
    }

    public User getUserByEmail(String email){
        log.info("Get user by " + email);
        return userRepository.findByEmail(email).get();
    }

    public User getById(Integer userId) {
        log.info("Get user by id " + userId);
        return userRepository.getById(userId);
    }
    public User updateUser(User user){
        log.info("Update user " + user);
        User userFromDB = userRepository.findByEmail(user.getEmail()).get();
        userFromDB.setEmail(user.getEmail());
        if (user.getFirstName() != null ){userFromDB.setFirstName(user.getFirstName());}
        if (user.getLastName() != null )userFromDB.setLastName(user.getLastName());
        if (user.getPassword() != null )userFromDB.setPassword(user.getPassword());
        if (user.getRole() != null )userFromDB.setRole(user.getRole());
        return userRepository.save(userFromDB);
    }

    public void delete(String email){
        User userFromDB = userRepository.findByEmail(email).get();
        log.info("Delete user " + userFromDB);
        userRepository.delete(userFromDB);
    }


}
