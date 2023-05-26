package com.ironhack.demo.dto;

public class UserDTO {
    private Long id;

    private String userName;

    private String email;

    private Long creditCardInfo;

    public UserDTO() {
    }

    public UserDTO(String userName, String email, Long creditCardInfo) {
        this.userName = userName;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(Long creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }
}
