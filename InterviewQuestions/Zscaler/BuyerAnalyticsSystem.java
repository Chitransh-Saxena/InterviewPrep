package com.DSA.InterviewQuestions.Zscaler;

/*
-> We are receiving following data from Kafka Stream
    -> seller_id, buyer_id, purchase_ts

-> We want to build an interface with following functionalities
    -> A certain seller can access this system and check his top K buyers
        -> Buyer with most purchases is Top 1 buyer, second most is Top 2 ..... Top K.



        1, 3, 10
        1, 3, 11
        1, 5, 25
        1, 4, 30
        1, 3, 35
        1, 5, 40

    -> For seller_id = 1, buyer_id = 3 has appeared 3 times, 5 has appeared two times.

-> Question
    -> If we have the liberty of setting up the data structure of our choice, how will we store this data such that the retrieval process is fast
        -> I used a Map of Map (Map<seller_id, Map<buyer_id, purchase_ts>
        -> Optimised it further to store like this -> Map<seller_id, Map<buyer_id, count_of_purchase_of_buyer)

        -> Was asked further optimisation
            -> I suggested an idea of Time Based Map, but I got too confused in my own answer
    -> LLD of above needed to be prepared

    -> Once LLD was done
        -> Consider this is an enterprise grade system, following questions were asked
        -> Where will you store this data?
            -> In what form?
            -> How to query?
        -> Optimisations on the basis of non-functional requirements
            -> IF SOMEONE ASKS FOR OPTIMISATION, ASK IN WHICH ASPECT? (SPACE, TIME, AVAILABILITY etc.)
                -> Each optimisation of a certain functional requirement comes from some non-functional requirement
                -> Example: If we are asked for low-latency, this means we can invest money on more servers to store auxiliary data which can reduce query time
                    -> The kind of HTTP connection we can make
                    -> Caching
        -> Once the data is stored in DB, DB has to be scaled
            -> Partitioning of Data
                -> I was not clear on this
                    -> On the basis of which column will I partition?
                    -> How do we decide which column? Otherwise, load will be uneven across the servers.
            -> Consistent Hashing
                -> I knew consistent hashing, but since partition itself is not clear, consistent hashing or any partition method was useless.

    -> Almost every answer I gave was half correct
        -> This is a good question, I need to make a full project for this.

*/

public class BuyerAnalyticsSystem {
}
