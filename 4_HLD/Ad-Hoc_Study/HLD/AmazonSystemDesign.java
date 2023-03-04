package com.DSA.HLD;

public class AmazonSystemDesign {

    /*

    -> Requirements
        -> Functional
            -> Search
            -> Cart
            -> Checkout
                -> Payment
            -> View Orders

        -> Non-Functional
            -> Low Latency
                -> Latency is also made up of two categories
                    -> Network Latency
                        -> Time to send a data packet from location A to B.
                        -> Network should be effecient enough.
                        -> Usually CDNs are used, in order to improve on latency.
                    -> Application Latency
                        -> Time taken by application from taking in request to producing response.
                        -> Load and Stress testing can be done to identify bottlenecks and improvise those areas of code
                -> Types of Scalability
                    -> Vertical and Horizontal Scaling
                        -> Vertical - Add more power to the server
                        -> Horizontal - Increase the number of servers.
                    -> Cloud Elasticity
                        -> These days cloud services are increasing because clouds have the ability to scale automatically with increase and decrease of load.
                        -> This also helps in optimizing cost
                        -> The process of adding and removing servers based on usage, is called cloud elasticity
            -> Highly Available
                -> Ability of the system to stay online and perform operations even after having some internal issues.
                    -> In order to increase availability, a system needs to identify as many points of failures as possible
                        -> Software Crash
                        -> Hardware Crash
                        -> Network issues
                        -> Planned Downtime

                -> Achieving High Availability
                    -> Fault Tolerance
                        -> If some server goes down, we prepare for backup
                        -> If out of n servers, few go down, we should be still be good to go.
                        -> Therefore, horizontal scaling along with proper load balancing and faulty server identification policy should be good.
                        -> Same goes for Load Balancers too.
                            -> A Load Balancer is also a single point of failure, thus we should include more than 1 LBs in order to avoid that issue.
                        -> So, the application as well as the deployment, everything should avoid having single point of failure.
                        -> So, in application level, we design the application in such a way, that fault tolerance is enabled at each level.
                            -> First, we decouple the application and create separate service for each of the roles and jobs (Monolith -> Microservice)
                            -> This provides us with each individual service, which we could choose to host in n-number of instances of servers.
                                -> Although is part of Redundancy, and not Fault Tolerance.
                            -> These would be reachable to us via some sort of API Gateway (nginx, some other LB etc.)
                            -> Similarly, we should also do scaling in DB
                                -> We can talk about Sharding and Indexing here.
                    -> Redundancy
                        -> Creating copy of servers running same service but on a different physically reachable server.
                            -> These copies are reached out in case of some other failed servers.
                            -> These configurations are programmed in the API Gateway or load balancer.
                            -> If the redundant server is dedicately used only as backup server, so it would be triggered only in case of primary server failure and not increased load.
                        -> We eliminate single point of failure by creating redundant nodes of each component and use them in case of primary node failure.
                        -> We could always idenitfy bottlenecks here and there.

                    -> Replication
                        -> In this case, unlike Redundancy, there are no standby or passive servers.
                        -> Always parallel instances of a service would be running.
                        -> When a single or more nodes go down, the remaining take the load.
                        -> Load could also be distributed geographically
                            -> Just in case, if the physical location of the servers is affected, an entire replica of the same system is physically present as backup.
                -> High Availability Clustering
                    -> It is a cluster(group) of servers running similar instances.
                        -> One of which goes down, other instances can serve the request.
                    -> The nodes in these clusters are connected by a private network, that is called a heartbeat network. The purpose of this network is to check for unhealthy instances.
                        -> And then do the needful for them
                            -> Automatic restart
                            -> Notification via slack.
                    -> A single state, shared by all the nodes in the cluster is achieved by distributed shared memory.
                        -> This is all coordinated by an orchestration service like Zookeeper
                    -> RAID is implemented on DISK level to achieve replication and redundancy on DISK level.
                        -> Highly Consistent



        -> Highly Consistent



        Business Flow Design (High Level Design)


        UI <---> LB <---> Recommendation Service <----> MongoDB (NoSQL for product inventory) < ----------- Kafka
                                                     |                                                          |
                                                     Item Service <---------------------------------------------| <----> In bound Service



        -> Here two flows are discussed
            -> UI (Homepage), this is basically composed of recommendations
                -> These recommendations are coming from a notification service
                -> This has a primary database as NoSQL, store, because the product info needs to be completely fetched
                    -> And a lot of search queries need to performed to it
                    -> So, better to store as noSQL
                -> This DB is populated by an Item Service
                    -> This service is basically talking to Kafka
                        -> Any new info and this service knows.
                        -> The info is pushed and DB is populated.
            -> In-bound service
                -> This is basically an abstraction for those users who put data to sell
                    -> THis is digested by Kafka and then this product is used in all the domains
                        -> Recommendations, searches etc.



        UI <---> LB <---> Recommendation Service <----> MongoDB (NoSQL for product inventory) < ----------- Kafka
                                                     |                                                          |
                                                     Item Service <-------------------------------------------> | <----> In bound Service
                                                                                                                |
                                                                                                                |
                                                                                                                |
                                                                                                                |
            UI (Search) <-----> LB <-----> Search Service  <---> Elastic Search   <------> Search Service<------|


        -> As soon as Kafka has some new info, it is published across several peices
            -> It is pushed to Search service as well
            -> From there, it is pushed to Elastic Search in such a manner that search operations could performed on that object
            -> Search service is going to give us APIs to perform search and get response


        UI <---> LB <---> Recommendation Service <----> MongoDB (NoSQL for product inventory) < ----------- Kafka
                                                     |                                                          |
                                                     Item Service <-------------------------------------------> | <----> In bound Service
                                                                                                                |
                                                Delivery Service                                                |
                                                  |                                                             |
                                                  |                                                             |
            UI (Search) <-----> LB <-----> Search Service  <---> Elastic Search   <------> Search Service<------|


        Delivery Service is something that has to be up and running while we are displaying products
            -> Because, we need to eliminate the products that we cannot display
            -> It will also tell in how much time would be we able to deliver the product

        Recommendation
            -> Each time a search input is made
                -> This info is put into Kafka
                -> This helps in building recommendation service
                    -> So, from Kafka this info would have gone to some analytics kind of DB, like Hadoop or something



        UI <---> LB <---> Recommendation Service <----> MongoDB (NoSQL for product inventory) < ----------- Kafka
                                                     |                                                          |
                                                     Item Service <-------------------------------------------> | <----> In bound Service
                                                                                                                |
                                                Delivery Service                                                |
                                                  |                                                             |
                                                  |                                                             |
            UI (Search) <-----> LB <-----> Search Service  <---> Elastic Search   <------> Search Service<------|
                                                |                                                               |
                                            Cart Service <---> Cart DB                                          |
                                                | --------------------------------------------------------------|



            Cart service is needed separately
                -> Items added to cart are added as noSql KV
                -> Again, info about cart is added to Kafka for recommendation purpose
                -> Spark and all those things could be used in that case.


            Apart from above
                -> We also need a Logistics Service
                    -> I have made an assumption that such info would be stored in Delivery Service
                -> Caching can be done for delivery locations and reachability





            Payments System Design

            UI (User Purchase) <---> LB <---> Order Taking Service <---> MySQL DB
                                                |
                                |---------------|---------------|
                                |               |               |
                        Inventory Service      Redis        Payment Service
                                |
                                |
                        Inventory DB




            -> User hits the UI to make a purchase.
                -> It talks to Order taking service and creates a new order and pushes into SQL database
                -> This info is also pushed into Redis
                    -> Callback feature would be used with some time to live.
                -> Each order would start from some initial state
                    -> And based on payment status, order status would be changed to SUCCESS, CANCEL etc.
                    -> Not just based on payment, could be any reason
                -> When an order is being placed, we need to block them in table
                    -> We need to make it inaccessible for other users while purchase for this is happening
                    -> This can be done by calling Inventory Service and updating the DB
                        -> Reduce count of the product from DB
                            -> Have a constraint that the count of item cannot go into negative
                    -> Transactional locks would be placed here, no 2 orders can modify the DB at the same time.
                        -> In case order fails, we need to increment inventory count.
                -> Also, when the order is placed, the same info is pushed in Redis cache along with  order status and time to live
                    -> In case payment service does not come back
                        -> The redis TTL will expire and notify us about the status and that TTL expired
                        -> This way, we can make necessary DB updated and notify the system as well as the user.
                    -> What if success status and TTL happen at the same time?
                        -> Determine TTL in such a way that success status has more time to come back
                            -> Usually UPI limits are of 5-10 mins, we can put TTL something like that only



            UI (User Purchase) <---> LB <---> Order Taking Service <---> MySQL DB   <---> Order Processing Service <----> Kafka (Same which was talking to search service)
                                                |
                                |---------------|---------------|
                                |               |               |
                        Inventory Service      Redis        Payment Service
                                |
                                |
                        Inventory DB

            -> Once order has been placed, Kafka even is triggered
                -> Updated in DBs for search and recommendations
                    -> If an item is sold out, we immediately need to update in search systems.
     */
}
