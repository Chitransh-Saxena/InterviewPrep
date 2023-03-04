package com.DSA.Graph.BFS_1;

import com.DSA.Graph.Utils.DoublyLinkedList;
import com.DSA.Graph.Utils.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    /*

        -> Problem
            -> Implement breadth first search in graph.
            -> Level by level searching technique
            -> Work on both connected and disconnected components
            -> Given will be a graph in the form of an adjacency list

            -> General Idea is, print source first, then it's immediate friends, then their immediate friends and so on, 

        -> Solution Approach
            -> Just like BFS in tree, items of each level will be stored in form of a queue
            -> Since we are gonna do traversal for both connected and disconnected components of graph
                -> Code is gonna be modified accordingly

            -> Time Complexity
                -> Because of multiple for loops, the complexity might look more, but since we are just traversing through entire graph
                -> It is perimeter
                    -> O(V + E)

    */

    public String bfs(Graph g) {

        StringBuilder result = new StringBuilder();

        // Default value is false
        boolean[] visited = new boolean[g.getVertices()];

        for(int i = 0; i<g.getVertices(); i++) {

            // From each source, we traverse it's adjacency list
            // We use visited just to be sure that we are not stuck in cycles

            if(!visited[i]) {
                result.append(bfsVisit(g, i, visited));
            }
        }

        return result.toString();
    }

    public String bfsVisit(Graph g, int source, boolean[] visited) {

        StringBuilder result = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        visited[source] = true;

        while(!queue.isEmpty()) {

            // At this point, we have added current source to queue, and we need to visit the connected nodes
            int curr = queue.poll();

            result.append(String.valueOf(curr));

            // Fetch adjacent vertices of the currentNode
            // If an adjacent vertex has not been marked as visited, enqueue it for further visit.
            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[curr] != null) {
                temp = g.adjacencyList[curr].getHeadNode();
            }

            // Adjacent vertices list is not null
            while(temp != null) {

                if(!visited[temp.data]) {

                    queue.add(temp.data);
                    visited[temp.data] = true;
                }

                temp = temp.nextNode;
            }

        }

        return result.toString();
    }

    public static void main(String args[]) {

        BFS bfs = new BFS();

        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " +  bfs.bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs.bfs(g2));
    }
}
