package com.DSA.Graph.DFS_2;

import com.DSA.Graph.Utils.DoublyLinkedList;
import com.DSA.Graph.Utils.Graph;

import java.util.Stack;

public class DFS {

    /*
        Problem
            -> Implement Depth First Search algorithm to iterate through a given graph
            -> How is it different from BFS?
                -> In dfs, we traverse down each source till we reach a leaf node, and backtrack to the source node
                    -> Then we move to next node
            -> Solution should work for both connected and disconnected components of graph

        Approach
            -> We have a wrapper function that traverses the vertices one by one
                -> This internally calls the function which does dfs
                -> The purpose of doing so is, to cover all the vertices of graph
                    -> Connected as well as disconnected components
            -> In the dfsVisit function (It is done in iterative fashion here)
                -> Approach is similar to BFS, but we use stack instead of queue
                    -> Why?
                    ->
                -> Start from the source
                    -> push the item in stack
                    -> We push the nodes from it's adjacency list into the stack as well
                        -> Post traversal, it is marked as visited
                    -> Using stack gives the correct sense of depth and order in which we need to go ahead
                        -> Usually this is done using recursion, but in order to mimic recursion (recursive stack space), we use stack here
                    -> Stack pops out the adjacent nodes (giving us node of the next level), instead of returning previous nodes that we pushed in.

             -> Time Complexity
                -> O(V + E)
    */

    public String dfs(Graph g) {

        StringBuilder result = new StringBuilder();
        boolean[] visited = new boolean[g.getVertices()];

        for(int i = 0; i<g.getVertices(); i++) {

            if(!visited[i]) {

                result.append(dfsVisit(g, i, visited));
            }
        }

        return result.toString();
    }

    private String dfsVisit(Graph g, int i, boolean[] visited) {

        StringBuilder res = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        stack.push(i);

        while(!stack.isEmpty()) {

            int curr = stack.pop();
            res.append(curr);

            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[curr] != null) {
                temp = g.adjacencyList[curr].getHeadNode();
            }

            while(temp != null) {

                if(!visited[temp.data]) {
                    stack.push(temp.data);
                }
                temp = temp.nextNode;
            }

            visited[curr] = true;
        }

        return res.toString();
    }
    public static void main(String[] args) {

        DFS dfs = new DFS();
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs.dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs.dfs(g2));
    }

}
