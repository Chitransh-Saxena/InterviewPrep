package com.DSA.HLD;

public class AlexaFindMy {

    /*
        Design

        Design Alexa FindMy


    -> Alexa, find my door key
        -> Tell me the location
        -> If no location, respond with answer



    -> Flow
        -> Add the device to some group
        -> Device is expected to be online
            -> Location would be saved
        -> If more devices, we just need save them in same group


        find my key

        -> my
            -> User is identified
        -> key


        Elastic Search
        -> Tokenize the entire blob of answer
        -> Perform a quick search
            -> How fast is this search
                -> Is it fast enough to priotize this over other noSQL.
        -> Return the answer

        User, {key: location, phone: location}

        -> In case of failure,
            -> Direct alexa tell not found
            -> Ask the user add it or check if design online


        POST(user, device, metaData) -> processing -> DB( Add the group items to DB, mapped to user)

        GET()


    -> Non Functional
        -> Load Balancer making it more available
        -> Servers
            -> Horizontally scale
            -> Avoids request not being served
                -> Always have primary and secondary
        -> DB
            -> Redundant Server
            -> Replicate
                -> Master-Slave
                -> Understand the scale


        After interview I went over my notes and came up with a better design

        -> In order to do this, alexa has to store the locations at some place
            -> Also, this needs to be quick, like really quick
                -> So, we are talking about minimal latency here
            -> In order to achieve such latency one of the either could be chosen
                -> either the responding server should be pretty close
                    -> A geographically close server
                -> Location and all these data has to be stored somewhere
                    -> Depending upon how we distribute our storage
                        -> Geographical distribution makes a lot more sense though
                    -> We can use some NoSQL database to store info like
                        -> {"userId", "[device1: metadata, device2: metadata]"}
                        -> But, we are also talking about realtime update
                            -> So, the currentLocation of the devices need to be updated periodically
                                -> Let's say, after a time period of 10 secs, alexa or the servers might request the location of device
                                    -> Now, if the response for location is same as before or within some certain radius, we do not update the database
                                -> If the location has been updated, we update the database
                        -> On top of this, we can add some cache, like redis cache or something, in order to even improve the latency further
                            -> Cache insert policy would be like this
                                -> Write-Back
                                    -> Every DB insert first has to go through cache
                                        -> Because this is a write as well as read heavy operation
                                        -> We cannot afford inconsistent data from cache
                                    -> In write-through, the DB insert will happen immediately
                                        -> But here, we can afford to do it after sometime, because there is a high chance that the data might change
                                            -> Person might move and location could change, so it is better to do it after some scheduled periodic interval

        https://kousiknath.medium.com/system-design-design-a-geo-spatial-index-for-real-time-location-search-10968fe62b9c
*/

}
