package com.DSA.LLD.Booking.Bridge_NotificationSystem;

public class QRNotification extends NotificationType{


    public QRNotification(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is a QR Type of notification");
    }

    @Override
    void notifyViaNotificationSender() {
        notificationSender.sendNotification();
    }
}
