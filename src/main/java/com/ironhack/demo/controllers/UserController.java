package com.ironhack.demo.controllers;

import com.ironhack.demo.models.Activity;
import com.ironhack.demo.models.User;
import com.ironhack.demo.services.ActivityService;
import com.ironhack.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @PostMapping ("/book-activity/{id}")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public Activity book(@PathVariable Long id) {
       return userService.bookActivity(id);
    }

    //buscar lógica de que el usuario solo pueda modificar su usuario
    @PatchMapping ("/update-profile/{id}")
    @ResponseStatus (HttpStatus.OK)
    public User update(@PathVariable Long id) {
        return userService.updateProfile(id);
    }

}
