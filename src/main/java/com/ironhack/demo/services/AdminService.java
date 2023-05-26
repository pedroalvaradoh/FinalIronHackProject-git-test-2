package com.ironhack.demo.services;

import com.ironhack.demo.dto.ActivityDTO;
import com.ironhack.demo.dto.UserDTO;
import com.ironhack.demo.models.Activity;
import com.ironhack.demo.models.Instructor;
import com.ironhack.demo.models.User;
import com.ironhack.demo.repositories.ActivityRepository;
import com.ironhack.demo.repositories.AdminRepository;
import com.ironhack.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    UserRepository userRepository;

    public List <Activity> activities(){
        return activityRepository.findAll();
    }

    public Activity addActivity(Activity activity){
        return activityRepository.save(activity);

    }

    //MANEJAR EXCEPCIONES
    public Activity updateActivity(Long activityId, ActivityDTO activityDTO) {
        Activity activity = activityRepository.findById(activityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activity.setActivityName(activityDTO.getActivityName());
        activity.setPrice(activityDTO.getPrice());
        activity.setActivityStatus(activityDTO.getActivityStatus());
        return activityRepository.save(activity);
    }

    public void deleteActivity(Long id) {
        activityRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity does not exist"));
        activityRepository.deleteById(id);
    }

    public List <User> checkUser(){
        return userRepository.findAll();
    }

    public User updateUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.OK, "User does not exist"));
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setCreditCardInfo(userDTO.getCreditCardInfo());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist"));
        userRepository.deleteById(id);
    }

}
