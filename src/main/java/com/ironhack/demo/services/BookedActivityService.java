package com.ironhack.demo.services;

import com.ironhack.demo.enums.ActivityStatus;
import com.ironhack.demo.enums.InstructorStatus;
import com.ironhack.demo.models.Activity;
import com.ironhack.demo.models.Instructor;
import com.ironhack.demo.repositories.ActivityRepository;
import com.ironhack.demo.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class BookedActivityService {

    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    ActivityRepository activityRepository;

    public List <Instructor> findAllInstructor() {
        return instructorRepository.findAll();
    }

    public List<Instructor> findInstructorByStatus(InstructorStatus instructorStatus) {
       return instructorRepository.findByInstructorStatus(instructorStatus);
    }

    public List <Activity> findActivityByStatus(ActivityStatus activityStatus) {
        return activityRepository.findByActivityStatus(activityStatus);
    }

    public List <Activity> findByPriceLessThanEqual(BigDecimal maxPrice) {
        return activityRepository.findByPriceLessThanEqual(maxPrice);
    }


}
