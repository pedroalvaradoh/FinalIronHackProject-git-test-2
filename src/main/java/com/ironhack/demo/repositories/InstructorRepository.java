package com.ironhack.demo.repositories;

import com.ironhack.demo.enums.InstructorStatus;
import com.ironhack.demo.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository <Instructor,Long> {

    public List <Instructor> findByInstructorStatus (InstructorStatus instructorStatus);
}
