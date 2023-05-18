package com.ironhack.demo.controllers;

import com.ironhack.demo.dto.ActivityDTO;
import com.ironhack.demo.dto.UserDTO;
import com.ironhack.demo.models.Activity;
import com.ironhack.demo.models.User;
import com.ironhack.demo.services.ActivityService;
import com.ironhack.demo.services.AdminService;
import com.ironhack.demo.services.UserService;
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
    @Autowired
    UserService userService;

    @GetMapping("/manage-activity")
    @ResponseStatus(HttpStatus.OK)
    public List<Activity> activityList() {
        return activityService.activityList();
    }

    @PostMapping("/add-activity")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity postActivity(@RequestBody Activity activity) {
        return adminService.addActivity(activity);
    }

    @PatchMapping("/update-activity-status/{activityId}")
    @ResponseStatus(HttpStatus.OK)
    public Activity patchActivity(@RequestBody ActivityDTO activityDTO) {
        return adminService.updateActivity(activityDTO);
    }

    @DeleteMapping("/delete-activityyy/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAct(@PathVariable Long id) {
        adminService.deleteActivity(id);
    }

    @GetMapping("/check-user")
    @ResponseStatus(HttpStatus.OK)
    public List<User> userList() {
        return adminService.checkUser();
    }

    @PutMapping ("/update-user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List <User> putUser(@RequestBody UserDTO userDTO) {
        return null;
    }
}
