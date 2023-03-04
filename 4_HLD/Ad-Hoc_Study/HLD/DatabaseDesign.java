package com.DSA.HLD;

public class DatabaseDesign {

    /*
        -> Things to think while deciding about database
            -> Structure of data
            -> Query Pattern that we have
                -> On what basis are we going to query the data in db
            -> Scale that we need to handle


        -> Caching Solution
            -> We can use caching for caching DB responses
            -> Can use it to cache another service's response in order to avoid latency
            -> Key-Value pair
            -> Redis, memcached
                -> Redis is battle tested

        -> File Storage Options
            -> For images and videos (Amazon, Netflix)
                -> For such kind of data, we use blob storage
                -> We just query using some id, and get the blob
                    -> No query, nothing
                -> Amazon S3
            -> While using Amazon S3
                -> It is a good practise to use something like CDN
                    -> Consider this, we have some item in S3, and lots of people around the globe want to access it
                    -> We might want to distribute image across CDN, so that geographically close servers can provide lower latency
            -> S3 + CDN

        -> Search use case (Amazon, Netflix, Uber)
            -> Text search should be enabled and responsive
                -> Can use Elastic Search in this case
                -> Supports fuzzy search (Typos etc.)
            -> Fuzzy support could have been implemented using Edit Distance (Check Leetcode problem)
            -> Elastic Search is not a database, they are search engines
                -> They claim they are providing availability and consistency, but data could be lost.
                -> Thus, these should never be made primary database
        -> Metrics
            -> Grafana, Prometheus
            -> Time Series Database
                -> Extension of RDBMS, but with a little difference functionality
            -> Write happens in append manner
            -> Read usually happens on bulk data (Last 1 hour of data etc.)


        -> When analytics needs to be done, then we need some sort of data warehouse
            -> We should be able to dump a lot of data
            -> Provide ways to do a lot of queries on that data
            -> These are used for offline reporting and to generate reports
                -> Not used like standard DB

        -> If we need ACID rules on our structured data
            -> Use SQL in this case
            -> ACID
                -> Atomicity - Instructions in query are atomic, either execute totally or not at all
                -> Consistency - Data is consistent across nodes and servers
                    -> If the value is successfully updated, then it is fine, but if a transaction fails, the values should not be partially updated, they should roll back to last successful state.
                -> Isolation - Multiple transactions should not affect each other
                -> Durability - Changes done should remain in case of system failure
            -> In case of inventory management, we need this
                -> Bookings
                -> Purchases of items
                -> Libraries

        -> If we want to store key value pair of items, like some user data blob mapped with userId
            -> Use some noSql solution
                -> Not a cache, but a noSql database as primary database
            -> MongoDB, couchbase, cassandra etc.
                -> We can store large volumes of data where structure is off
                -> Cloud storage, cost effective
                    -> DB like cassandra can scale to multiple data centres
     */
}
