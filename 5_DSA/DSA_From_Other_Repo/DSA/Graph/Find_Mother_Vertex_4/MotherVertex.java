package com.DSA.Graph.Find_Mother_Vertex_4;

import com.DSA.Graph.Utils.DoublyLinkedList;
import com.DSA.Graph.Utils.Graph;

import java.util.Arrays;

public class MotherVertex {

    /*
        Problem
            -> Given a graph, find the mother vertex
            -> Mother Vertex
                -> It is a vertex v, such that all other vertices can be reached from v.
                -> No mother vertex in disconnected graph

        Approach
            -> Could not think of approach myself.
            -> Solution is based on Kosaraju's Strongly Connected Components Algorithm
                -> Initially we run a DFS on the graph and make sure all the nodes are visited.
                    -> In a disconnected graph, all would not be visited.
                -> Theory is, last vertex visited in the DFS would be the mother vertex
                    -> Major questions
                        -> How do we know this theory is true?
                            -> At last vertex, all other items in visited would be true (DFS only stops when all nodes are visited)
                                -> This means, so far when we visited, no node could reach all nodes and thus last vertex is pending
                                -> Thus, only last vertex which will be traversed in DFS has the potential to be mother vertex.
                            -> Also, Mother vertex is a vertex from which we can reach all the nodes
                                -> If this is true, then if we are doing DFS on the mother vertex, visited array should mark every index as true, right?
                                -> So, this is the theory which will be implemented
                        -> How do we know which is last vertex
                            -> We keep track of it using a variable (lastV), and checking with certain conditions (visited array is full or not)
    */

    public int getMotherVertex(Graph g) {

        int numOfVertices = g.getVertices();
        boolean[] visited = new boolean[numOfVertices];
        Arrays.fill(visited, false);

        int lastV = 0;  // Initialize with 0, change according to conditions later in the code

        // DFS traversal to find out the last traversed vertex.
        for(int i = 0; i<numOfVertices; i++) {

            if(!visited[i]) {
                DFS(g, visited, i);
                lastV = i;
            }
        }

        // Now that we have lastV, all we need is a validation
        // Rest visited, and do a DFS from lastV, if we get all visited true, lastV is the mother vertex, else return -1.

        Arrays.fill(visited, false);
        DFS(g, visited, lastV);

        for(boolean val: visited) {
            if(!val) {
                return -1;
            }
        }

        return lastV;
    }

    private void DFS(Graph g, boolean[] visited, int i) {

        visited[i] = true;

        // Get the adjacent list to traverse them
        DoublyLinkedList<Integer>.Node temp = null;
        if(g.adjacencyList[i] != null) {
            temp = g.adjacencyList[i].getHeadNode();
        }

        while(temp != null) {

            if(!visited[temp.data]) {
                DFS(g, visited, temp.data);
            }
            temp = temp.nextNode;
        }
    }

    public static void main(String[] args) {

        MotherVertex motherVertex = new MotherVertex();
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + motherVertex.getMotherVertex(g));

    }
}
