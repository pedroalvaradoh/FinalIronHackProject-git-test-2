package com.ironhack.demo.controllers;

import com.ironhack.demo.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {

    @Autowired
    InstructorService instructorService;


}
