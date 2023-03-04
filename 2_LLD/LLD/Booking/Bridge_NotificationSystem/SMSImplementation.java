package com.DSA.LLD.Booking.Bridge_NotificationSystem;

public class SMSImplementation implements NotificationSender {


    @Override
    public void sendNotification() {

        System.out.println("Sending SMS");
    }
}
