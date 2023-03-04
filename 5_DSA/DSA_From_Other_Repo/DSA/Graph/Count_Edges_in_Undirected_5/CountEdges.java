package com.DSA.Graph.Count_Edges_in_Undirected_5;

import com.DSA.Graph.Utils.DoublyLinkedList;
import com.DSA.Graph.Utils.Graph;

public class CountEdges {

    /*
        -> Problem
            -> Given a graph, find the number of edges in a graph (undirected graph)

        -> Approach
            -> To count all the edges, we need to iterate everything
            -> In adjacency list, if we have a linked list at some index, (source and destinations)
    */

    public int countEdges(Graph g) {

        int numOfVertices = g.getVertices();

        for(int i = 0; i<numOfVertices; i++) {

            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[i] != null) {

                temp = g.adjacencyList[i].getHeadNode();
            }


        }
    }
}
