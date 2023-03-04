package com.DSA.LLD.Booking.Bridge_NotificationSystem;

public class TextNotification extends NotificationType{


    public TextNotification(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is a Text type of notification");
    }

    @Override
    void notifyViaNotificationSender() {

        notificationSender.sendNotification();
    }
}
