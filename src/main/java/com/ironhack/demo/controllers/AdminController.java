package com.ironhack.demo.controllers;

import com.ironhack.demo.models.Activity;
import com.ironhack.demo.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    ActivityService activityService;

    @GetMapping ("/check-activity")
    @ResponseStatus (HttpStatus.OK)
    public List<Activity> activityList(){
        return activityService.activityList();
    }
}
