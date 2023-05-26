package com.ironhack.demo.services;

import com.ironhack.demo.dto.UserDTO;
import com.ironhack.demo.models.Activity;
import com.ironhack.demo.models.User;
import com.ironhack.demo.repositories.ActivityRepository;
import com.ironhack.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ActivityRepository activityRepository;

    public Activity bookActivity(Long id) {
        return activityRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Apologies, the activity you are trying to book is not available"));

    }

    public User updateProfile(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.OK, "User does not exist"));
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setCreditCardInfo(userDTO.getCreditCardInfo());
        return userRepository.save(user);
    }

}
