package com.DSA.LLD.Booking.Bridge_NotificationSystem;

public class WhatsappImplementation implements NotificationSender {


    @Override
    public void sendNotification() {
        System.out.println("Whatsapp notification");
    }
}
