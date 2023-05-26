package com.ironhack.demo.services;

import com.ironhack.demo.models.Activity;
import com.ironhack.demo.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;
    public List <Activity> activityList(){ return activityRepository.findAll();}

    public void deleteActivity(Long id) {
        activityRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, the activity you are trying to delete does not exist"));
        activityRepository.deleteById(id);
    }
}
