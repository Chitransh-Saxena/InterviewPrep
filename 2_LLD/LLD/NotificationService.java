package com.DSA.LLD;

public class NotificationService {

    /*
        Requirements
            -> Service should be decoupled from the main application
            -> Should support multiple notifications
                -> Text
                -> QR code
                -> Audio
            -> Should support multiple mediums of notifications
                -> SMS
                -> EMAIL
                -> WHATSAPP
            -> Each type should have their own processor (SRP)
            -> Should be loosely coupled for extensibility



        HLD -> MQ -> NotificationService

        Behaviour for the main service would be based on bridge design pattern
            -> Decouple abstraction from implementation
            -> Helps when there is a lot of variation in behaviour of the class
                -> Basically, it creates a bridge between abstraction and notification
        But if it supports only single notification type (TEXT and not QR or audio)
            -> Then basic Inheritance with polymorphism should be enough.

        Why choose bridge pattern here?
            -> Since multiple types of notifications are there
                -> Call them abstraction
                    -> TEXT
                    -> QR
                    -> AUDIO
                -> Implementation can be done in following ways
                    -> SMS
                    -> EMAIl
                    -> WHATSAPP

            -> Without choosing bridge
                -> For each implementation of each abstraction we need to create a class
                    -> N * M
            -> With Bridge
                -> ~N + M
            -> TextMessage tm = new TextMessage(new Email());
            -> QRMessage qm = new QRMessage(new SMS());
            -> tm or qm.sendNotification();

     */
}
