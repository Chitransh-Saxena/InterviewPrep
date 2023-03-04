package com.DSA.LLD.Booking.Facade;

public class User {

    private String userName;
    private String userEmail;
    private Long userNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    public User(String userName, String userEmail, Long userNumber) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userNumber = userNumber;
    }
}
