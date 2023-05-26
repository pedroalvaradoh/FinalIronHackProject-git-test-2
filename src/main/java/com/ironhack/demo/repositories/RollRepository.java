package com.ironhack.demo.repositories;

import com.ironhack.demo.models.Roll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollRepository extends JpaRepository <Roll,Long> {
}
