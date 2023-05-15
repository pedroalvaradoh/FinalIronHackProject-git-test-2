package com.ironhack.demo.services;

import com.ironhack.demo.models.Activity;
import com.ironhack.demo.repositories.ActivityRepository;
import com.ironhack.demo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    ActivityRepository activityRepository;

    public List <Activity> activities(){
        return activityRepository.findAll();
    }
}
