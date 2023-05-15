package com.ironhack.demo.services;

import com.ironhack.demo.repositories.ActivityRepository;
import com.ironhack.demo.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    ActivityRepository activityRepository;



}
