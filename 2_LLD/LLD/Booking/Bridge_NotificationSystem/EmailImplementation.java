package com.DSA.LLD.Booking.Bridge_NotificationSystem;

public class EmailImplementation implements NotificationSender {


    @Override
    public void sendNotification() {
        System.out.println("Email Notification");
    }
}
