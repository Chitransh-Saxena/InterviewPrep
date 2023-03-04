package com.DSA.Graph.Utils;

public class Graph {

    /*
        -> Implementation of Graph
        -> Graph implemented using Adjacency List has following two components
            -> Number of vertices (int vertices)
            -> Array of the linked list to store the adjacency list of the vertices(DoublyLinkedList<Integer>[] adjList)
                -> Each index of the array denotes the vertex
                -> Linked List on that vertex denotes the adjacent nodes.


    */

    int vertices;

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public DoublyLinkedList<Integer>[] adjacencyList;  // An array of DoublyLinkedList which takes in Integer data

    public Graph(int vertices) {

        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];

        // Adjacency list is an array
        // Each index will be null if not initialized
        for(int i = 0; i<vertices; i++) {

            adjacencyList[i] = new DoublyLinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {

        if(source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);
        }

        // In case of undirected graph, uncomment below
        // this.adjacencyList[destination].insertAtEnd(source);
    }

    public void printGraph() {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++)
        {
            if(adjacencyList[i]!=null){
                System.out.print("|" + i + "| => ");

                DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null)
                {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            }
            else{

                System.out.println("|" + i + "| => "+ "null");
            }
        }
    }
}
