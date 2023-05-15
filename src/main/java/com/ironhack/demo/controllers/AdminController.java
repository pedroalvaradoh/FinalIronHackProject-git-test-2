package com.ironhack.demo.controllers;

import com.ironhack.demo.dto.ActivityDTO;
import com.ironhack.demo.models.Activity;
import com.ironhack.demo.services.ActivityService;
import com.ironhack.demo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    ActivityService activityService;
    @Autowired
    AdminService adminService;

    @GetMapping ("/manage-activity")
    @ResponseStatus (HttpStatus.OK)
    public List<Activity> activityList(){
        return activityService.activityList();
    }

    @PostMapping ("/add-activity")
    @ResponseStatus (HttpStatus.CREATED)
    public Activity postActivity (@RequestBody Activity activity) {
        return adminService.addActivity(activity);
    }

    @PatchMapping ("/update-activity-status")
    @ResponseStatus(HttpStatus.OK)
    public Activity patchActivity(@RequestBody ActivityDTO activityDTO) {
        return adminService.updateActivity(activityDTO);
    }
}
