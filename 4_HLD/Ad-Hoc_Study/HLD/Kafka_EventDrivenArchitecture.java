package com.DSA.HLD;

public class Kafka_EventDrivenArchitecture {

    /*

        -> Regular Monolith Architecture

            Application UI -> Tightly Coupled Application -> Database Servers


        -> Regular Microservices Architecture

            Application UI -> [LB + Horizontally Scaled Servers] -> [Sharded DB]

            -> The scaled servers would be running Kubernetes Pods and the application would be running on them

            -> Also, in the a well designed architecture, usually different types of services have their own type of database.
                -> The tables are grouped in a well designed manner (based on use case and all that).
                -> So, we can visualize each service talking to it's own type of database

        -> Now, there comes a problem when there is a dependency between services.
            -> When one service produces some output, it needs to be consumed by some other service.
                -> Now, with each event, some communication has to be triggered.
        -> Also, because of all the logics and dependencies, the architecture becomes synchronous, rather than asynchronous

        -> Event Driven Architecture
            -> Events
                -> Things that happen in a software
                -> One user enters his details in UI, they need to be updated in some specific DB
                    -> This is an update
                -> Someone changed his email address
                    -> Have to reflect in every other place
                        -> Event
            -> Application UI -> [Backend Architecture]

            Backend Architecture

            UI (Action1) -> LB -> Service 1 <---> Kafka
                                            |
                                            |
            UI (Action2) -> LB -> Service 2 <---> Kafka


            SO basically, the BE services won't be talking directly in Event driven architecture
                -> Instead, each event, could be programmed in such a way using Kafka or any Event Streaming Platform
                    -> That from that event, whatever needs to be done, is triggered asynchronously



            What is Apache Kafka?
                -> Open Source Event Streaming Platform
                -> Usually used as MQ
                -> So, basically if some event happens, and some other service is interested in that event
                    -> Then generally we trigger that action via some synchronous event
                    -> So, basically service1 would be waiting for the action to complete

                -> But, in event streaming architecture
                    -> Here, each service will tell that some event happened
                    -> If other service is interested, they get it or consume that information
                    -> This is called Tell / Get pattern
                        -> One service tells that something happened, and it is now in the event queue
                        -> Other services will be listening to it, and whichever wants, consumes it.
                        -> Else, this info will always be in queue forever*
                            -> This can be handled via TTL and etc.
                -> Event Streaming
                    -> Streaming data means a constant flow of data, along with information about state or event.
                    -> Streaming data is processed real-time as it is delivered into the system
                    -> Although priority and all can be programmed.



                Producer ---------> TOPIC -------> Consumer
                                      |
                [------------------Message Queue---------]


                Producer <------> Kafka Broker <----------> Consumer

                -> Kafka broker is basically a server
                    -> Since it is a server, it is listening to some TCP connections to make connections
                        -> 9092 is default port for Kafka
                -> Producer
                    -> Publishes content to broker
                -> Consumer
                    -> Consumes content from broker

                -> What protocol?
                    -> Not sure


                Producer <------> Kafka Broker => [Topic A, Topic B] <----------> Consumer

                -> Topic
                    -> It is logical partitioning of data
                    -> So, when a producer writes, it has to specify for which topic it is writing
                    -> Similarly, consumers are waiting for some topics to be published and consumed


                Producer <------> Kafka Broker => [Topic UserNames= ["John", "Prince", "Doe"]] <----------> Consumer

                -> Producer produces some strings and puts them in the Topic UserNames
                    -> In that topic, a queue is formed, and names are added
                    -> Consumer, who has maintained a TCP connection with Kafka Broker
                        -> It consumes the data
                -> In Kafka, the consumers make use of HTTP Poll model, instead of HTTP Push model(RabbitMQ uses HTTP Push model)



                What if the topics get too large?
                    -> For a single topic, partitions are created
                    -> If, the content of Topic UserNames gets too large, it will create partitions (just like sharding in DB)
                        -> So, based on certain properties, the data would be distributed amongst partitions
                            -> Can we decide that logic?
                                -> Does it matter who decides as long as it serves the purpose?


                   ->                   Kafka Broker

                                        UserNames Topic

                                Partition A             Partition B


                    -> Why do we do this partitioning?
                        -> As the dataset grows larger, the performance to operate on it increases.
                            -> Thus, just like Database, in order to reduce query time, we try to reduce query size too
                                -> Here as well we create partitions



                Queue vs Publish - Subscribe
                -> Queue - Messaged is published once, and it needs to be consumed only once
                    -> Horizontally scaled service where only 1 server needs to address the request
                -> Pub-Sub
                    -> Message is published once, but remains in the queue till all the necessary services have consumed the topic


                    Example: Youtube

                    How does an upload of a video happens?

                    Device -> Upload Service -> Kafka [NewUploads Topic] -> Multiple consumers

                    -> Here, when a new video is uploaded from some device, it goes to upload service
                    -> From here, the raw video, after some processing is given to Kafka broker
                    -> From there, it goes to multiple consumers
                        -> One would start generating all different video formats
                        -> One would check for piracy and all that stuff
                        -> One would be notification upon some condition



                What about both?
                    -> Kafka tried to do this.
                        -> Done using Consumer Groups
                    -> So, earlier, the messages would remain in Kafka broker in some form of data structure until consumed as expected.

                    -> Consumer groups
                        -> Producer produces something, it goes into Kafka broker, to the topic, into some relevant partition
                        -> Consumer group is basically the group of consumers
                        -> If there is only one consumer group
                            -> All the partitions are this groups responsibility
                        -> If there are 2 groups
                            -> Group 1 would take partition A and Group 2 would take partition B.
                        -> Multiple partitions could go to one user group
                            -> But one partition cannot go to multiple groups

                    -> With the above implementation, as soon as the message is pushed to some Kafka Broker, into some partition, it is read and popped off
                        -> Now, because we see this sequence of popping off, 1 by 1, we are able to implement queue here
                        -> This is still not clear much
                    -> Now, if we have multiple consumers of similar type of data in one group, once the data is queued, it is read by all the consumers
                        -> And is popped off, thus, implementing a queue like structure
                            -> Earlier, it had to remain in whatever list or queue we had, until all the consumers consume it
                            -> But, because of Consumer Groups, that implementation has been optimized a lot.
                                -> This could still be async because of different execution time of each service
                        -> Now, since multiple services are consuming this data, we get parallel processing as well.



            What happens in Distributed System
            -> Well, the data is replicated
                -> Kafka Broker 2 is created on a different port
                -> Now, this broker will also have the same data about the partitions
            -> Now, if Replication is there, some sort of master-slave or master-master architecture would be there
                -> Here, The master-slave is implemented at partition level.
                -> One broker is not entirely the master / leader
                    -> One of it's partition is
                    -> So, partition A would be master in Broker B
                        -> And partition B would be master in Broker A
                -> This way, we do not loose entire data even if one master goes down.
                    -> How does that matter? We already had replicated data, right?

            -> Now, this information, that which partition is master in which broker, where is this stored?
                -> ZooKeeper
                    -> This basically keeps information about which partition is leader in which broker
                    -> This information is kept as metadata, and is customized at need
                    -> Every broker on a Kafka cluster is also named a Bootstrap Server.
                        -> All brokers have the metadata required for the clients (producer or consumer) to discover brokers.
                        -> When a client connects to one of the brokers (which are already configured as bootstrap servers in the Kafka configuration) it makes a "metadata request".
                        -> The response includes information about topics, partitions, leader brokers, etc. Once the client gets this info, then - in the case of a producer- it makes the write request directly to the leader broker for that specific partition.
                -> I need more information here, but I think, based on the request, zookeeper would return some metadata, along with appropriate port number
                    -> To which the request has to be sent
                    -> Not sure though, need to do some more research
                -> Even if we are using just 1 broker, we need zookeeper

            -> How to use?
                -> Spin up zookeeper
                -> spin up kafka cluster
                -> Create topic
                -> Create producer
                -> Create consumer

     */
}
