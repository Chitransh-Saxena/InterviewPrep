package com.DSA.LLD.Booking.Bridge_NotificationSystem;

public class MainBridge {

    public static void main(String[] args) {

        TextNotification textNotification = new TextNotification(new EmailImplementation());
        textNotification.notifyViaNotificationSender();

        QRNotification qrNotification = new QRNotification(new WhatsappImplementation());
        qrNotification.notifyViaNotificationSender();
    }
}
