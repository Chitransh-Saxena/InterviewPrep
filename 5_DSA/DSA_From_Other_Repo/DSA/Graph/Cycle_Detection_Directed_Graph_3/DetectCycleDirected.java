package com.DSA.Graph.Cycle_Detection_Directed_Graph_3;

import com.DSA.Graph.Utils.DoublyLinkedList;
import com.DSA.Graph.Utils.Graph;

import java.sql.Struct;

public class DetectCycleDirected {

    /*
        Problem
            -> Given a directed graph in form of an adjacency list
            -> Check if there are any cycles
                -> Vertices connected in such a way that they create a cycle

        Approach
            -> Do a traversal (BFS or DFS)
            -> Usually we keep track of visited nodes by keeping a visited array
                -> In this case, since we are talking about cycles, so we can init another visited array just for the current iteration
                -> If we end up at some node which was already visited in current cycle, we have seen a loop
            -> We use DFS on each node
                -> In each recursive cycle for one node, we check in the visitedInCycle array if the currentNode has already been visited in current cycle
                -> If not, we mark both visited array's index as true
                -> Fetch the adjacency list of currentNode
                    -> Iterate using recursive method
                    -> If cycle is found, return true
                        -> Else return false;
            -> Time Complexity
                -> Traversal - O(V + E)
            -> Space
                -> O(1)

    */

    public boolean checkCycleInDirectedGraph(Graph g) {

        int numOfVertices = g.getVertices();

        boolean[] visited = new boolean[numOfVertices];
        boolean[] visitedInCycle = new boolean[numOfVertices];      // Worst case, graph can have one vertex and all items in form of a linked list

        for(int i = 0; i<numOfVertices; i++) {

            if(hasCycle(g, i, visited, visitedInCycle)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(Graph g, int i, boolean[] visited, boolean[] visitedInCycle) {

        if(visitedInCycle[i]) {
            return true;
        }

        // If it is already visited, and not flagged in visitedInCycle, then there is no loop
        if(visited[i]) {
            return false;
        }

        visited[i] = true;
        visitedInCycle[i] = true;

        // Get head of adjacency list of the current source
        DoublyLinkedList<Integer>.Node temp = null;
        if(g.adjacencyList[i] != null) {
            temp = g.adjacencyList[i].getHeadNode();
        }

        while(temp != null) {

            // Run hasCycle method recursively on each item of the adjacency list
            if(hasCycle(g, temp.data, visited, visitedInCycle)) {
                return true;
            }

            temp = temp.nextNode;
        }

        visitedInCycle[i] = false;

        return false;
    }

    public static void main(String[] args) {

        DetectCycleDirected detectCycleDirected = new DetectCycleDirected();
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycleDirected.checkCycleInDirectedGraph(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycleDirected.checkCycleInDirectedGraph(g2));
    }
}
