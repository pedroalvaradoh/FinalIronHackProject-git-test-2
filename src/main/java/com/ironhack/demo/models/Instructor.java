package com.ironhack.demo.models;

import com.ironhack.demo.enums.InstructorStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Instructor extends User {
    private Long phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "instructor_status", columnDefinition = "ENUM('ON','OFF','BUSY')", nullable = false)
    private InstructorStatus instructorStatus;
    @OneToMany
            (mappedBy = "instructor", cascade = CascadeType.ALL)
    private List <BookedActivity> bookedActivityList;

    public Instructor() {
    }

    public Instructor(String userName, String email, Long creditCardInfo, List<BookedActivity> bookedActivityList, Long phoneNumber, InstructorStatus instructorStatus) {
        super(userName, email, creditCardInfo, bookedActivityList);
        this.phoneNumber = phoneNumber;
        this.instructorStatus = instructorStatus;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public InstructorStatus getInstructorStatus() {
        return instructorStatus;
    }

    public void setInstructorStatus(InstructorStatus instructorStatus) {
        this.instructorStatus = instructorStatus;
    }

    public List<BookedActivity> getBookedActivityList() {
        return bookedActivityList;
    }

    public void setBookedActivityList(List<BookedActivity> bookedActivityList) {
        this.bookedActivityList = bookedActivityList;
    }
}

