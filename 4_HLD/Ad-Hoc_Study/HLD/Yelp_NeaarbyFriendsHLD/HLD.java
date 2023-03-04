package com.DSA.HLD.Yelp_NeaarbyFriendsHLD;

public class HLD {

    /*
        Yelp
            -> People register themselves, and with their GPS, application finds nearby restaurants, hotels, friends etc.

        -> Requirement
            -> Functional
                -> User accounts: People have to create account, register themselves etc.
                -> Search : People should be able to search nearby places, areas of interest, etc.
                -> Feedback: User should be able to add review about the place

            -> Non-Functional
                -> Availability
                -> Scalable
                -> Consistency
                -> Performance

        -> Resource Estimation
            -> 100 million unique users
            -> 50 million daily active users
            -> 500 million places

            -> Number of Servers estimation
                -> Number of Daily Active Users / RPS of a server
                -> 50000000 / 8000
                -> Do the math

            -> Storage Estimation
                -> Assumptions
                    -> 500 million places
                    -> To store 1 place, how much size it would take?
                        -> Depends where and how are we storing the this data
                        -> considering a regular DBMS, it should be around 1000 bytes (longitude and latitude)
                        -> Photos attached to each photo (at least 1 photo)
                            -> Each photo will take around 256 bytes
                            -> It is not photo size, it will be size of row which will hold URL to Amazon S3 or some image storage blob
                    -> 1 million daily reviews
                        -> Added on daily bases
                        -> 500 bytes for each review
                            -> Can calculate by number of word limit * average word size
                    -> Is there some other aspect?
                        -> User information
                            -> Registration etc.

                -> Total Storage Required
                    -> Places + Photos + Reviews + Users = Total
                    -> Do the math, but approx = 1 TB

        -> High Level Design

            -> API Signature
                -> search(category, user_location, radius)
                -> search(name_of_place, user_location, radius)
                -> addPlace(Place place)
                    -> Place can have all the items needed for a place to be in DB
                -> addReview(placeId, userId, review, rating)

            -> Storage Schema
                -> Place
                    -> name
                    -> category
                    -> Longitude
                    -> Latitude
                    -> PhotoId
                        -> This will be foreign key to Photos table which will store photoId and photo URL
                    -> Rating

                -> Photos
                    -> photoId
                    -> photoUrl

                -> Users
                    -> userName
                    -> FirstName
                    -> LastName
                    -> Email
                    -> Phone Number



            -> Designing of Components
                -> Segment Producer
                    -> Communicates with the google map API
                    -> Comes back with the map and divides into several segments upon which we can do our operations
                    -> Helps us narrow down the number of places to be searched
                -> Quad Tree Servers
                    -> It is a tree type data structure which contains location segments in the form of a tree
                    -> QuadTree sever finds the list of places in a given radius
                    -> This mainly aids the search functionality
                -> Aggregators
                    -> QuadTree sends the information to aggregator which interacts with the user and returns the result to the user
                -> Read and Write servers
                    -> Since there are going to be a lot more reads than writes, we segregate read and write servers
                -> Storage
                    -> SQL
                        -> For the given schema's data
                    -> No-SQL
                        -> In order to optimize the search, we will store the list of places against a segment id in a cache
                        -> These segment Ids will take us to appropriate segment in the quadtree and search can be optimized
                -> Load Balancer
                    -> To distribute the requests amongst the servers accordingly


                -> Workflow
                    -> Searching a place
                        -> Request goes from LB to Read servers
                        -> Read servers requests the QuadTree servers to find all the places which fall in the given radius
                        -> Quadtree servers send the result to aggregator server to refine the search and respond with data that can be processed for UI

                    -> Adding a place or feedback
                        ->

    */
}
