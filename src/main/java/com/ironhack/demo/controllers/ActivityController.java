package com.ironhack.demo.controllers;

import com.ironhack.demo.models.Activity;
import com.ironhack.demo.repositories.ActivityRepository;
import com.ironhack.demo.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {

@Autowired
ActivityService activityService;

    //obtener actividades
    @GetMapping ("/check-activity")
    @ResponseStatus (HttpStatus.OK)
    public List <Activity> activityList() { return activityService.activityList();

    }
    

    //delete activity
    @DeleteMapping ("/delete-activity/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        activityService.deleteActivity(id);

    }

}
