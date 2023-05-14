package com.ironhack.demo.repositories;

import com.ironhack.demo.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository <Activity, Long> {
}
