package com.ironhack.demo.repositories;

import com.ironhack.demo.enums.ActivityStatus;
import com.ironhack.demo.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository <Activity, Long> {

    List <Activity> findByActivityStatus (ActivityStatus activityStatus);

}
