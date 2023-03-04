package com.DSA.InterviewQuestions;

public class MeeshoHLD {

    /*
            On Meesho app, users search for a wide range of products and catalogs through the search feature.
        To provide our users a seamless and smooth search experience,
        -> we want to design the autosuggest search terms functionality as users type a search term.

        E.g: sa -> saree, saree set , sana sarees


        Requirement

        -> Functional
            -> Design the autosuggest search terms functionality as users type a search term.
                -> Trie based approach
                -> Elastic Search based approach

        -> Non-Functional
            -> Low Latency
            -> High Consistency
                -> Every DB related thing or in-memory DB
                    -> We create replicas
                        -> Master-Slave architecture to maintain this.
            -> High Availability
                -> Scaled horizontally, There is no single point of failure
            -> Highly Scalable
                -> In a day wif we have 60-70 million hits on search service per day
                    -> 60 Million string searches per day.

                -> 20% increase in a month, already happened. (Sale days)
                    -> System should accomodate large sets of data from where search can happen
                        -> Last 30 days.
                        -> If tomorrow requirement is of 60 days data, we should support it.

                -> System should not underperform in higher traffic
                    -> This feature should not become a bottleneck.


        UI ---> API / LB --> Search Service --> DB


        Design

        -> If someoone is typing 'sa'

        Approaches
            -> Trie like data structure for storage
                -> Tree like storage mechanism

            -> If we have some word, "sa"

                    "sa"

                "sad" 	"saree"


            -> We can populate our tree of words and suggestions, based on our inventory and whatever search items we choose.
                -> We need to choose our words properly for the storage
                -> Because each unnecessary word is costing us something, we want minimize cost.


            -> Graph Storages
                -> Since this tree like structure is basically collection of nodes
                    -> We can use some sort of graph like Database to store this.
            -> Alternative Data Storage Strategy
                -> Elastic Search
                    -> Tokenises the strings that we store
                        -> It can perform fast string based search
                    -> Also supports Fuzzy search
                        -> Supports typos and everything.



            UI <--> LB <---> Search Service <---> Elastic Search [Last 30 days, could increase to 60 days] <---> Inventory / Prdocuts DB


            Scalability

            -> Requirement
                -> Systems should support 60 million QPD at baseline.
                -> System should scale for upto 25-30% in case of scale
                -> Dataset could also require to fetch from last 60 days instead of 30 days
                -> Show users top X suggestions.
                    -> Ranked based on popularity.

            -> 1 and 2.
                -> Search Service
                    -> Horizontally scale across multiple servers
                    -> Application Level scaling.
                -> Since horizontal scaling is there
                    -> I need to balance load accordingly
                        -> Round-Robin if there is no prioritization
                        -> But, on special days, maybe we can redirect that specific traffic to some certain servers, but this is again, not much necessary.
                -> In case, we see a sudden spike in traffic
                    -> This can be identified at Load Balancer level.
                        -> We can use ad-hoc servers, and program our cloud or whatever platform
                            -> To spin up extra pods and servers in case of this.
                -> In case of Sales and pre-known traffic events (spike of 25-30%)
                    -> We can spin up servers beforehand and make them available for load.



            -> Making Trie as in-memory
                -> If we can support storage - 1,00,000
                    -> 4 bytes of average per word
                -> 4,00,000 and even if it is a lot more, we can store it in memory
                    -> Upto 4-5 GB should be enough.


            Diagram


            UI ---> API / LB --> Search Service --> DB



            Meesho Search System

            -> Inventory and some basic recommendation system
                -> This would be powered by some inventory DB and recommendation would be powered by some ML or whatever algorithm
            -> Search Service
                -> Searches based on input
                -> Talks to service, that fetches data from Elastic Search or Trie (whichever we choose)
                    -> Responds.
            -> Above two will talk to a common DB


            With ElasticSearch

            UI (homepage) <--->  LB <---> Recommendation Service <----> Product inventory (MySQl or some DB, with Master-Slave Architecture)
                                                                            |
                                                                            |
            UI (Search) <---> LB <-----> Search Service <-----> Elastic Search



            With Trie

            UI (homepage) <--->  LB <---> Recommendation Service <----> Product inventory (MySQl or some DB, with Master-Slave Architecture)
                                                                                        |
                                                                                        |
            UI (Search) <---> LB <-----> Search Service <-----> Trie (In-Memory, but can be made available across nodes) <-----> Trie Populating Service


            Trie Populating Service
                -> This will look at give days of data and populate the trie
                -> How are we updating and when does update happen?
                    -> 30 -> 60 days
                    -> New products are added to inventory
                -> Kafka or any other Event Driving the entry of products into Trie Structure

            Search Service
                -> Filter and decide what items to show and what to do with them.


            UI (homepage) <--->  LB <---> Recommendation Service <----> Product inventory (MySQl or some DB, with Master-Slave Architecture)	<----------->Kafka Cluster
                                                                                                                                                                |
                                                                                                                                                                |
            UI (Search) <---> LB <-----> Search Service <-----> Trie (In-Memory, but can be made available across nodes) <-----> Trie Populating Service <--->	|




            Trie Structure which will hold the data

            -> Indexing or hashing based on characters, words and everything.
            -> Ranking needs to be maintained
                -> Items within same level, should be arranged on their order of popularity
                -> This will mean, most popular item is left most
                -> And we can choose to pick top most.
                -> But again, this might not be what user wants.
                -> In order to improve the algorithm
                    -> It is better to do a depthwise search, based on input
                        -> And get the top X, popular elements based on words entered.

            -> String.


            class Node {

                String product;
                Integer popularityIndex;
                Integer hashCode;
                    -> Hashcode could be generated based on popularity and product String.
                        -> With this, trie structure would kind of break down
                    -> Better to generate hashing based on indexing
                        -> Do a DFS in the trie, to get top X elements.



            }

            class Node {
                Node parent;
                String product;
                Integer popularityIndex;
                Integer hashCode;
                List<Nodes> products;			// Store the list of valid words based on current word, in a level wise manner, with just 1 or minimum characters required to form a valid string.

                List<Nodes> previousSuggestion;
                Time TTL;

                if(TTL exceeeded) nullify previousSuggestion else return that in case of products.

                -> If space is a factor, we should not store sorted suggestions within node.
            }



            Node (some word) = 4 + 4 + 4 + ... + 4;


            -> Do a DFS in the trie, to get top X elements. (Based on popularity)


            Further optimization to this data store

            -> We can shard based on characters or words
                -> A -> P in 1 shard
                -> Q -> Z in anther shard

                -> Now, similarly, as our search word grows, we can look up in necessary subtrie structure and find our words in logarithmic time.
                    -> Because our dataset is distributed in a tree like structure, where traversal is based on lexographical thing and popularity.


                    Node
            Node1	Node2	Node3 ...

        Node11	Node12


            -> How will I handle typos
                -> Within Search service, check the validty of word or something
                    -> Like saree should be searched, but user typed saareee
                -> Based on user input
                    -> We should try to come up with some top X words
                        -> Based on the edit distance of the character
                            -> By minimam modifications, make a valid string and then search it.


            -> Is it work of Search Service?
                -> Better to do it in search service for latency and better usecase.



            -> For peak sale times and peak traffic hours
                -> Maintain a cache.
                -> Have cached in things like search stroke and list of valid words
                -> Cache Eviction
                    -> LFU, because we want to give popularity the priority.


            -> Introduce the cache, populate it with correct data
                -> Then this goes to Trie data structure
                -> Write - Back stratrgy
                    -> I will write in Trie after 10 or 15 secs.


            UI (homepage) <--->  LB <---> Recommendation Service <----> Product inventory (MySQl or some DB, with Master-Slave Architecture)	<----------->Kafka Cluster
                                                                                                                                                                |
                                                                                                                                                                |
            UI (Search) <---> LB <-----> Search Service <-----> Cache for popular items during sale times <---> Trie (In-Memory, but can be made available across nodes) <-----> Trie Populating Service <--->	|



            -> In case search space grows, heap will run out of memory for trie
                -> Parition the data based on lexographical order
                    -> Choose which partition to go to and perform the search in that subtree.

     */
}
