package com.ironhack.demo.controllers;

import com.ironhack.demo.enums.ActivityStatus;
import com.ironhack.demo.enums.InstructorStatus;
import com.ironhack.demo.models.Activity;
import com.ironhack.demo.models.Instructor;
import com.ironhack.demo.services.ActivityService;
import com.ironhack.demo.services.BookedActivityService;
import com.ironhack.demo.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

    @RestController
public class BookedActivity {

    @Autowired
    BookedActivityService bookedActivityService;
    @Autowired
    ActivityService activityService;

    @Autowired
    InstructorService instructorService;

    @GetMapping ("/instructor/find-all")
    @ResponseStatus (HttpStatus.OK)
    public List <Instructor> findAll() {
        return bookedActivityService.findAllInstructor();
    }

    @GetMapping ("/instructor-find-by-status/{instructorStatus}")
    @ResponseStatus (HttpStatus.OK)
    public List <Instructor> findByInstructorStatus(@PathVariable InstructorStatus instructorStatus) {
        return bookedActivityService.findInstructorByStatus(instructorStatus);
    }

    @GetMapping ("/activity-find-by-status/{activityStatus}")
    @ResponseStatus (HttpStatus.OK)
    public List <Activity> finsByActivityStatus(@PathVariable ActivityStatus activityStatus) {

        return bookedActivityService.findActivityByStatus(activityStatus);
    }

    @GetMapping ("/activity-find-by-price/")
        public  List <Activity> findByPrice (@RequestParam BigDecimal maxPrice){
        return bookedActivityService.findByPriceLessThanEqual(maxPrice);
    }

}
