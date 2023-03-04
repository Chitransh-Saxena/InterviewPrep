package com.DSA.HLD.ArchitectureStudy;

public class Architecture {

    /*
        Single Tier Applications
            -> One client - Mobile, desktop app
            -> One server - Also in the same mobile app etc.
            -> Example: MS Office, games etc.
            -> Pros
                -> Latency - 0
            -> Cons
                -> Once the application is pushed, owner has no control over application
                -> Updates are not possible

        Two Tier Applications
            -> Client - UI, BE
            -> Server - DB
            -> Example:
                -> todo list
                -> Even if code is hacked by the client, there is no harm, since it is just a to-do list

        Three Tier Applications
            -> Client - UI
            -> App Server - BE
            -> DB Server - DB

        N-Tier
            -> Cache
            -> MQs
            -> LBs


        Web Architecture
            -> When all the tiers and components run in conjunction to produce a working application

        Client Sever Architecture
            -> Basic two-tier and three tier applications
            -> Types of Clients
                -> Thin - Holds just the UI, nothing else
                -> Thick - UI + Business Logic
            -> Web Server
                -> Function is to recieve a request from the client and provide with an appropriate response
                -> Apart from application Server, we have other types of servers too
                    -> Proxy
                    -> Mail
                    -> File
                    -> Etc.
                -> Server Side Rendering
                    -> UI is rendered in the server side and then the response is sent to UI

            -> Communication between Client and Server
                -> Request - Response Model
                    -> Client requests, server responds
                -> HTTP Protocol
                    -> Communication over web happens with this protocol
                    -> Set of rules which every one has to follow for a smooth communication
                    -> Stateless protocol
                        -> every request - response is independent, having no info of previous messages
                    -> REST API and Endpoints
                        -> Backend code has REST APIs implemented for the communication over web to happen
                        -> Representational State Transfer
                        -> REST API
                            -> APIs which adhere to REST architectural concepts
                            -> It is an interface
                            -> Communication happens via HTTP only
                            -> REST just uses the HTTP to establish a connection
                                -> REST also enables the servers to cache the response of frequently used queries.
                            -> REST based services expose an endpoint or a URL which the client can hit in order to get some response
            -> API Gateway
                -> Clients requests directly do not go the application server
                -> They are hit to the gateway, which decides where to send the request.

            -> HTTP Push and Pull Model
                -> Pull
                    -> Client sends a request, then server responds with a response/
                    -> This is basic Pull model
                -> Push
                    -> Client requests, once the request has gone to server, it will respond with the data
                    -> But, server keeps pushing new data to the client if it has any for the same request.
                    -> This is also called as callback
                    -> User Notifications are based on this only
                -> AJAX Long Polling
                    -> Used to add asynchronous behaviour to the web page
                    -> Client sends request to server after every X unit of time
                    -> Client is updated each time
                -> Web Socket
                    -> Preferred when we need a persistent bi-directional low latency connection between client and server
                    -> Use cases include chat applications, real-time social media streams, browser based multiplayer games etc.


        Scalability
            -> If our application is growing, having just one computer does no good
            -> We will encounter huge traffic, DDOS attacks, low latency etc.
            -> We scale the application in order to enable us to handle more requests and balance it better

            -> Types
                -> Vertical
                    -> Add more power to the existing server/servers
                -> Horizontal
                    -> Add more servers of similar power
                    -> Balance the load of the requests within these severs
                -> Cloud Elasticity
                    -> Clouds scale dynamically based on loads
                    -> This helps in saving resources
                    -> Process of adding servers, removing when needed, stretching vertically, is called cloud elasticity

            -> How to improve and test scalability of our application
                -> Profiling
                    -> Application profiler and code profiler to understand the bottlenecks
                -> Caching
                    -> Avoid thrashing
                -> CDN
                    -> Use it for better latency
                -> Data Compression
                    -> API requests can be serialized
                    -> Required data can be compressed and either used in that format
                -> Testing Scalability
                    -> CPU Usage
                    -> Throughput
                    -> Latency
                    -> RAM
                    -> UX


        Availability
            -> Ability of system to stay online despite having issues in infrastructure
            -> How to achieve high availability
                -> Fault Tolerance
                    -> Decouple the application
                    -> Multiple horizontal scaling at each level
                        -> Multiple DB servers
                            -> Master Slave architecture
                            -> RAID levels
                        -> Multiple Application Severs
                            -> Horizontal Scaling (Replication basically)
                            -> Redundancy
                                -> Duplicating the servers and keeping them on standby just in case they are needed
                        -> Multiple data centers
                            -> In case one goes does, we can have another
                        -> Multiple API gateways
                            -> Multiple LBs
        Load Balancing
            -> Distribute the load of the incoming traffic to appropriate severs according to some algorithm
            -> Good LBs perform health checks on the servers by manually switching them on and off and checking if remaining are working as expected or not

        DNS Server
            -> Domain Name System
            -> Translates the website name to the respective application server for proper request response

        Database
            -> Persistent Data Storage
            -> Can get the data by querying with respective language
            -> RDBMS and NoSQL
                -> RDBMS
                    -> Data is stored in the form of tables
                    -> There is some sort of relation in the data
                    -> Follows ACID properties
                        -> Atomicity - Instructions in query are atomic, either execute totally or not at all
                        -> Consistency - Data is consistent across nodes and servers
                            -> If the value is successfully updated, then it is fine, but if a transaction fails, the values should not be partially updated, they should roll back to last successful state.
                        -> Isolation - Multiple transactions should not affect each other
                        -> Durability - Changes done should remain in case of system failure

    */
}
