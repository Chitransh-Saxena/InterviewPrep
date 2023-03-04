DSA For Amazon
-> Tree
-> Zig Zag BST
-> Root to Path (LCA)
->
-> DP
-> Sliding window maximum
-> Max product subarray
-> Buy Sell Stocks 1 and 2
-> Find a maximum number that can be arranged from a given set of lists of numbers. (Backtracking will be slow here)
-> LCS
-> LIS
-> Decode ways
-> Word Ladder 2
-> Strings
-> Heap
-> Graph (Revise on Sunday past questions (and basics of BFS and DFS, time complexity clearly)
-> Basic BFS and DFS
-> Time complexity
-> Why and how
-> Topological sorting.
-> Djsiktra
-> Prims
-> Some other famous algorithm


Design Chess Board
Design Logger
Design Book my show
Dashboard for running flights.
-> Should have search features.

Nielsen project
Current Project
-> DB design
-> DB decisions
-> Role played in Rehire
-> LLD
-> SOAP Integration
-> Understand SOAP properly
-> Algorithm
-> Error handeling to the max
-> Prod release, log tracking, gathering metrics of API hits for our algorithm based using DB queries.
-> This is a good habit because in case something goes wrong, we have a idea of how much has gone wrong.

Design Uber

Authentication
Authorization

Spring Boot.

{
-> Tree properties
-> LCA - DONE
-> BFS
    -> Iterative Solution
        -> Why is queue data structure used to keep track of level items?
            -> Time complexity of queue operations
        -> Time and space complexity of the solution
    -> Recursive solution - DONE
        -> Time Complexity - DONE
-> DFS Iterative Soluition
    -> DONE
-> Flatten BST to Linked List
-> Zig Zag level order traversal - Done
-> Sliding window maximum - Too much effort, maybe some other time
-> Max product subarray - DONE
-> Buy Sell Stocks 1 and 2 - DONE
-> Find a maximum number that can be arranged from a given set of lists of numbers. (Backtracking will be slow here)

}

{

LLD
-> LLD Revision
    -> Which design pattern used under which situation
    -> Map famous questions to famous design patterns
    -> Note the important code snippet of that design pattern (like singleton, bidge, strategy etc)
-> Book my show
-> Chessboard
-> Logger
-> Graph System Design Primer
-> Graph DSA question for flight related questions.
-> Design Notification Service

	-> DB
		-> Concurrency handeling
		-> Transactions and locks
			-> Types of locks
			-> When to use when.

}

{
-> Kth smallest element in a tree
-> Path to given node
-> Merge two binary trees
-> Vertical sum of a binary tree
-> LCS
-> LIS
-> Decode ways - ~~~
-> Word Break - Understood, done, but not fully satisfied
-> Word Ladder 2
-> House Robber - Robber
-> Stack Using Queue
-> Queue using stack

}

{
Saturday
	-> Heap
		-> Revision of basics
			-> How heap works internally
			-> Time complexity of each operation and how
			-> Applications of heap
		-> Merge K sorted Lists
		-> LRU Cache
		-> Maximum Sum Combinations
        
        Time Complexity

        -> Snake Ladder - Can do, easy stuff
        -> Kinght on Chess Board. - Watch nXn queens problem
            
}


[
-> Kth smallest element in a tree
-> Path to given node
-> Merge two binary trees
-> Vertical sum of a binary tree'

-> Revision of all previous stuff and done questions

-> Heap
    -> Revision of basics
    -> How heap works internally
    -> Time complexity of each operation and how
    -> Applications of heap
    -> Merge K sorted Lists
    -> Maximum Sum Combinations
    -> Find Median from Data Stream

-> Time complexity analysis of logarithmic functions
    -> And how memoization changes them

]

{
Sunday
-> Strings
-> HLD related to amazon
-> some previous document is there.

			-> Again, various types of components understanding and designing solutions around it
			-> Design a hotel booking platform. - DONE
            -> DB Master-Slave architecture
			-> Meesho HLD probable domain
				-> e-commerce - DONE
				-> Payments - DONE
					-> Trading
				-> Storing images - DONE
				-> Browsing products - DONE
				-> Notification Service
					-> Check cricbuzz system design.
					-> How is instant and correct notification sent across multiple clients?

				-> Just to be on the safer side
					-> Netflix
						-> Streaming platform
							-> Streaming
							-> Video onboarding
							-> Payments
								-> Subscription
            -> Kafka Architecture
                -> Pros and cons of vairous message queues
                    -> Why did we choose nats server in Nielsen
                        -> How did that algorithm work?
                        -> Contributions?
                            -> Worked in development on worker nodes, what they returned, how the result was compiled
            -> How does deployment happen in cloud.
				-> Understand about deployment in Walmart.
				-> What does it mean by deployment?
					-> What are we shipping?
					-> How are we shipping?
					-> How is it made available?
					-> How is updated code made accessible to clients?
					-> What is the downtime in deployment?
			-> Which technology are we choosing and wh?
				-> Pros and cons of the tech stack
			-> Components for Scalability, Availability and Partition Tolerance
			-> Understand call time.
			-> Profiling of the components and the services.
			-> SPOF Conditions
			-> Understand each layer and the annotations provided by spring boot for it
				-> How do these annotations help in development
				-> Why SpringBoot vs Spring
					-> Why Spring over JSP and all
			-> Understand the DB design, schema, sharding logics and all
				-> Spring Boot DB
					-> What Walmart uses (Datasource, JDBCTemplate, queries)
				-> Primary and secondary DB
				-> Connection Pooling etc.
			-> Docker, Kubernetes
			-> Understand Testing and Junit
				-> Implement in EA-Preference service and understand each method, library and everything that is used
				-> How would you test SOAP service?
				-> Why are unit tests important? What benefit do they serve?


            -> HLD
                -> Web Architecture revision - Done
                -> Grokking components revision - Done
                -> Kafka Architecture and interview questions
                -> Text search engines - Elastic Search as non-primary DB
                -> Image Stores - S3 works along with some CDN Cloudfare etc.
                -> CDNs - Cloudfare, akamai
                -> Notification Service - Mostly based on MQ, Long Polling and Web Sockets - Done
                -> E-commerce - Done
                -> Payments - Done
                -> Hotel Booking - Done
                
                
                -> Book My Show - Done
                -> Uber
                -> Trading Platform - D
                -> Messanger - D
                -> Instagram - D
                -> Facebook News Feed
                -> Twitter Search
            
            
                -> Spring Boot
                    -> Annotations basics
                    -> GET, POST, PUT, PATCH
                    -> jdbc template
                    -> data source configuration
                    -> primary and secondary database
                    -> Connection Pooling
                    -> Transactions and Locks
                

                -> API call time
                -> SPOF Conditions
                    -> Single Point Of Failure conditions
                        -> Software Crash
                        -> Hardware Crash
                        -> Network issues
                        -> Planned Downtime
                -> Design Patterns
                    -> For Microservices
                
                -> DB
                    -> Connection pool
                    -> Primary and secondary database
                        -> spring.datasource-primary.url=jdbc:mysql://localhost:3306/primarydb
                        -> spring.datasource-secondary.url=jdbc:h2:mem://localhost:8082/secondarydb
                        -> To configure multiple data sources in Spring Data JPA we need to group the Model classes and Repository interfaces for each data source under different packages, this is how we tell Spring what belongs to which data source
                    -> What is jdbctemplate
                        -> How is a new template created for different datasource
                        -> Lets us connect to DB and do queries
                            -> Internally uses JDBC API, but removes its problems
                                -> We do not have to write code of creation connection, closing connection etc.
                            -> Provides us methods like namedParameter and regular ? to use on queries.
                    -> What is the usecase of this?
                        -> Why not standard prepared statement with standard jdbc connection
                        -> Or why not move to hibernate and stuff
                    -> Sharding, Indexing, Replication and Redundancy
                        -> Scaling of DB
                    -> NoSQL
                        -> Revise about Redis completely
                        -> Understand how it connects multiple servers and fetch into the data into redis cache.
            
                -> Nielsen Project In Depth
    -               -> On-Prem Distributed system
                    -> How did docker requests move
                    -> Nginx on network layer
                    -> Our one on application layer
                    -> Testing
                        -> Load
                        -> Failure
                        -> Various kind of requests testing
                        -> Component level failure testing
            
            
                -> Multithreading
                -> Basics till thread pooling and thread safety from educative course
                -> Clarity on internal structure and time complexities of various data structures.


}

