package com.ironhack.demo.repositories;

import com.ironhack.demo.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository <Instructor,Long> {
}
