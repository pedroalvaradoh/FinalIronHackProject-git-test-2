package com.ironhack.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Instructor extends User{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Long phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "instructor_status", columnDefinition="ENUM('ON','OFF','BUSY')",nullable = false)
    private InstructorStatus instructorStatus;
    @ManyToOne
    private List <Member> memberList;

    public Instructor(String userName, String email, Long creditCardInfo, List<BookingCart> bookingCartList, Long phoneNumber, InstructorStatus instructorStatus, List<Member> memberList) {
        super(userName, email, creditCardInfo, bookingCartList);
        this.phoneNumber = phoneNumber;
        this.instructorStatus = instructorStatus;
        this.memberList = memberList;
    }

    public Instructor() {
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

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
}
