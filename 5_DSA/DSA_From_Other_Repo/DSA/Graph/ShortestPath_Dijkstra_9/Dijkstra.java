package com.DSA.Graph.ShortestPath_Dijkstra_9;

public class Dijkstra {

    /*
        Problem
            -> Given a weighted directed graph
            -> Return a list of shortest distance from given source to all the nodes.


        Single Source Shortest Path
        -> BFS can find shortest path in a unweighted graph
        -> In real life applications, we have mostly weighted graphs
            -> In such situations we use
                -> Dijkstra's Algorithm
                    -> With graph which has non-negative weights
                -> Bellman-Ford Algorithm
                    -> With graph which can have any sort of weights (-ve included)


        Edge Relaxation
            -> Consider we have a graph, and we have to calculate shortest distance of all the nodes from a given node
            -> When we have stored some distance from source to a node, and when we find another distance which is shorter, we update the distance
                -> This operation is called Edge Relaxation
                -> This is a primary function in shortest path algorithms


        Dijkstra's Algorithm
            -> It is a greedy algorithm
            -> We maintain a data structure to store node and distance
                -> This will store distance of nodes from source till current node.
            -> We init above DS will source ,0
            -> We start iterating the DS
                -> Visit all the reachable nodes
                -> Update the distance if current distance is shorter than distance present in DS
                -> Once all the reachable nodes are traversed, mark current node as visited.

            -> TC:
                -> O(V + ELogV) - Logic same as Prim's algorithm

    */
}
