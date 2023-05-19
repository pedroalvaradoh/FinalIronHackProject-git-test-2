package com.ironhack.demo.repositories;

import com.ironhack.demo.models.BookedActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedActivityRepository extends JpaRepository <BookedActivity, Long> {

    //checkInstructorByStatus, checkActivityByStatus, checkActivityByPrice


}
