package com.DSA.Graph.Intro_0;

public class Intro {

    /*
        Safety Netting
            -> What are we talking about?
                -> Graph Data structure
                    -> Nodes are some classes which have some sort of information
                    -> These nodes are connected to other nodes based on relation between nodes.
                    -> This kind of data structure is perfect to denote friendships in social media networks of people
            -> Why is this important?
                -> Complex problems such as traversing path in some certain way
                    -> Shortest Path
                    -> Min cost etc are based on graph data structures
                -> Social Media networks are based on graph data structure
                    -> Recommendations of people, posts etc is basically done on the basis of info in the graph
                -> Because of such common business use case and complexity involved in problem solving, it is considered a good skill
                    -> Thus, is asked in a lot of interviews
            -> How important is this?
                -> It is not asked much in common interviews or first rounds
                -> But is definitely a benchmark for companies like Google, Uber, Atlassian etc.
            -> What can be done with this information?
                -> Shortest Path Algorithms
                -> People Connection based problems etc can be solved using it.
            -> Where can I get further knowledge on this?
                -> GFG
                -> Educative practical projects course with Java
                -> Educative DSA course


        Core Basics
            -> Graph
                -> It is a set of nodes which are connected to each other in form of a network

            -> Components of Graph
                -> Vertex
                    -> It is a node. Essential part of the graph
                    -> Collection of vertices form a graph
                    -> These are kind of similar to linked list nodes
                -> Edge
                    -> Link between two vertices (nodes)
                    -> It can be directed or undirected
                        -> Undirected one has no sense of direction, and thus traversal can be done from any node to any node
                        -> But in case of directed graphs, traversal can only be done from source to destination of arrow

            -> Types of Graphs
                -> Undirected vs Directed graphs - Explained above
                -> Weighted vs Unweighted graphs
                    -> Each connection has a weight or a cost associated with it
                    -> Some relations are binary - Friend or not friend. Here weighted graph is not needed
                    -> But in some relations, like cost of travelling from one node to another - we need weights associated
                -> Connected graphs
                    -> Undirected graph where there is at least one connection between any 2 nodes.
                    -> Trees are connected graphs with no cycles.

            -> Ways to represent a graph
                -> Adjacency List
                -> Adjacency Matrix

    */
}
