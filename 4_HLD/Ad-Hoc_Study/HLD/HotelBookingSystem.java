package com.DSA.HLD;

public class HotelBookingSystem {

    /*
        Design something like Airbnb

        -> User should be able to see the property by location size etc
        -> Other users should be able to add the property to listing for customers


        Non-Functional Requirement
            -> Low Latency
                -> Use CDNs, different servers for static and dynamic content
                -> Use different geographical servers for better latency
            -> High Availability
            -> High Consistency
            -> Scale



            System Design

            -> Hotel Service
                -> This will expose REST APIs to add and remove hotels
                -> Add images and all that
                -> Hotel has to be a relational DB, because we need to save a lot of structured data and perform ACID operations
                -> We can use MySQL DB
                    -> Which can be scaled and made available using master slave sharding
                    -> Sharding
                        -> It is dividing the tables rows into different servers and based on primary key, find out which server to go and query that.
                        -> It improves data storage, increases speed of query return
                    -> Images about the hotel would be stored in CDN
                        -> The image URL would be stored in MySQL DB
                        -> Images could be stored in Amazon S3
                            -> Images are stored as a blob
                            -> It is cost effective
                            -> Some normalization could be done for table clean up
                                -> Think where

                -> To handle spike in traffic, this component can be horizontally scaled.




            Design Diagram

            UI App for Hotel Managers <--> Load Balancer <--> Hotel Service <--> MySQL DB (Master Slave Nodes)
                                                ^
                                                |
                                                |
                                                > CDN

            -> When a modification is done by Hotel Service, we need to update the users
                -> If some new hotel is added or images are added to old, or room count or anything is updated

            For this reason, we will connect Hotel Service to a Kafka clusters
                -> Multiple consumers would be sitting on top of this kafka clusters
                -> Those clusters will populate their data store



           UI App for Hotel Managers <--> Load Balancer <--> Hotel Service <--> MySQL DB (Master Slave Nodes)
                                                ^                       ^
                                                |                       |
                                                |                       |
                                                > CDN                   |------------------> Kafka Cluster
                                                                                                |
                                                                                                |
                                                                                                |
                                    Elastic Search Cluster <--> Search Consumer <---------------|


           -> When the kafka is populated with hotel info, the Search component, which the users use while booking, is populated with new information
                -> The search mechanism is enabled using Elastic Search
                    -> Elastic Search is a fast text search mechanism
                    -> NoSQL datastore which stores as (productId, {product_details_as_json_blob})
                    -> Searching happens in json_blob
                        -> It is further tokenized and search algorithms are used
                    -> It also supports fuzzy search
                        -> Handles typos etc.
                -> In case we need to scale
                    -> We can increase number of nodes in Kafka cluster
                    -> We can increase count of Search Service
                    -> We can scale Elastic Search



            UI App for Hotel Managers <--> Load Balancer <--> Hotel Service <--> MySQL DB (Master Slave Nodes)
                                                ^                       ^
                                                |                       |
                                                |                       |
                                                > CDN                   |------------------> Kafka Cluster
                                                                                                    |
                                                                                                    |
                                                                                                    |
            User UI <--> LB <--> Search Service <--> Elastic Search Cluster <--> Search Consumer <--|

            -> Again, search service is the primary backend to which the UI is talking to.
                -> This again is horizontally scalable


            Booking

            UI App for Hotel Managers <--> Load Balancer <--> Hotel Service <--> MySQL DB (Master Slave Nodes)
                                                ^                       ^
                                                |                       |
                                                |                       |
                                                > CDN                   |------------------> Kafka Cluster
                                                                                                    |
                                                                                                    |
                                                                                                    |
            User UI <--> LB <--> Search Service <--> Elastic Search Cluster <--> Search Consumer <--|
                                                                                                    |
            Booking UI (same client though) <--> LB <--> Booking Service <--------------------------|
                                                                     |-----> MySQL Database

            -> For booking, we are storing the info in a separate MySQL cluster
                -> To make it scalable, else could have used Hotel Service DB only
            -> Once the bookings are made, this info is pushed to Kafka cluster
                -> Those hotels or rooms are eliminated from search operation


            UI App for Hotel Managers <--> Load Balancer <--> Hotel Service <--> MySQL DB (Master Slave Nodes)
                                                ^                       ^
                                                |                       |
                                                |                       |
                                                > CDN                   |------------------> Kafka Cluster
                                                                                                    |
                                                                                                    |
                                                                                                    |
            User UI <--> LB <--> Search Service <--> Elastic Search Cluster <--> Search Consumer <--|
                                                                                                    |
            Booking UI (same client though) <--> LB <--> Booking Service <--------------------------|
                                                            |                                       |
                                                    Payment Service     |-----> MySQL Database <----| ----> Notification Service


            -> Once some booking is made, it is notified to customer
            -> Or if booking is cancelled, hotel is notified, info is passed to Kafka, and room is made back available



            UI App for Hotel Managers <--> Load Balancer <--> Hotel Service <--> MySQL DB (Master Slave Nodes)
                                                ^                       ^
                                                |                       |
                                                |                       |
                                                > CDN                   |------------------> Kafka Cluster
                                                                                                    |
                                                                                                    |
                                                                                                    |
            User UI <--> LB <--> Search Service <--> Elastic Search Cluster <--> Search Consumer <--|
                                                                                                    |
            Booking UI (same client though) <--> LB <--> Booking Service <--------------------------|
                                                            |                                       |
                                                    Payment Service     |-----> MySQL Database <----| ----> Notification Service
                                                                                      |
                                                                                    Redis
                                                                                      |
                                                                                      |
                UI (Booking history) <----> LB <---> Booking Management Service   <---|




            For manage the bookings
                -> Checking previous bookings etc. we will use BookingManagement Service
                -> While someone is making a booking, a DB lock would be acquired
                    -> That room/rooms would be blocked and until we are notified it is booked, we hold
                        -> We have to take certain steps accordingly
                    -> Example: If booking is cancelled because payment failed, what do we do?
                        -> We can use Redis callback feature
                            -> If we pass some info through redis, we can also pass some ID and TTL
                                -> If TTL expires, and we did not get success or some notification, we notify that booking failed.




            ACID Properties
                -> ACID
                    -> Atomicity - Instructions in query are atomic, either execute totally or not at all
                    -> Consistency - Data is consistent across nodes and servers
                        -> If the value is successfully updated, then it is fine, but if a transaction fails, the values should not be partially updated, they should roll back to last successful state.
                    -> Isolation - Multiple transactions should not affect each other
                    -> Durability - Changes done should remain in case of system failure
























     */
}
