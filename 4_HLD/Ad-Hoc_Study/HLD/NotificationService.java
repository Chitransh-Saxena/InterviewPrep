package com.DSA.HLD;

public class NotificationService {

    /*

        Requirement
            -> Functional
                -> Send Notifications
                -> Plug and play type
                -> Prioritization
                    -> Rate Limit

            -> Non-Functional
                -> Highly Available
                -> Low Latency
                -> High Performance (Real time experience)
                -> Durable - Message should last, no duplication


            Components Design

            -> Notification Service
                -> Expose APIs to add notification to system
                -> Receives message from client, performs validation
                    -> If validated, add msg to Kafka topic.
                    -> Messages will be picked for further processing from here

            -> Notification verification, validation and prioritization
                -> Metadata
                    -> This should contain info about source, destination, medium, priority etc.

            -> Rate Limiter
                -> Rate the number of notifications sent to some certain user or any criteria
                    -> Do not want to bombard user with way too many notifications
                -> Rate limiter could be applied on number of requests per client basis

            -> Notification Dispatcher
                -> Deliver notification to the respective Kafka Queue
                    -> Have different queue for different types of notifications
                -> For each notification type, there would be a list of consumers

                -> We should be able to add or remove notification types via this service
                -> Handling high priority
                    -> For each type of notification, we can add two queues, High Priority and Normal
                    -> High Priority msgs like OTP will be immediately dispatched
                        -> Msgs like promotional msgs would be delayed a bit.

            -> Notification Tracker
                -> Update notification status in some DB
                    -> Can use RDBMS here.
     */
}
