package com.DSA.LLD.Booking.Bridge_NotificationSystem;

public abstract class NotificationType {

    NotificationSender notificationSender;

    public NotificationType(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    abstract void notifyViaNotificationSender();
}
