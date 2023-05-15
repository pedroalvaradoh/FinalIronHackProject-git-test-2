package com.ironhack.demo.controllers;

import com.ironhack.demo.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookedActivity {

    @Autowired
    InstructorService instructorService;

}
