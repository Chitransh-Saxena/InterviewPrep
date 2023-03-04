package com.DSA.Graph.MinimumSpanningTree_Prim_8;

import java.util.Arrays;

public class Intro {

    /*
        Spanning Tree is a graph without a cycle
            -> So, if a graph has cycles, we cannot make spanning tree out of it

        Minimum Spanning Tree
            -> Given a weighted undirected graph
            -> Generate a MST such that all the nodes are either directly or indirectly connected and the total weight is minimum.

        Prim's Algorithm
            -> Picks one of the nodes
            -> Puts in MST set.
                -> Finds minimum weights that connect one to rest of the other nodes.

        Approach
            -> Maintain 2 sets
                -> One set for the elements which are selected in MST
                -> One set for all other elements
            -> Find min weight edge, that connects current MST element to the remaining nodes.
                -> Greedy idea

    /*
        Approach
            -> The problem basically wants a minimum spanning tree based on the given coordinates
            -> Apply Prim's Algorithm

        Prim's Algorithm
            -> Start with any node
            -> Keep a visited array to make sure we do not add same element to MST twice
            -> Frontier
                -> Every possible node that can be reached from current node is frontier of the current node.
                -> It is a data structure which stores elements that are reachable from current node.

            -> We add source node to min heap along with distance to source node
                -> add 0,0 to min heap
            -> Now, that there is some element in min heap, we iterate till it is not empty or we have visited all nodes.
                -> Pop the top element of minHeap
                    -> Check which of the nodes is closest to it
                    -> Add it to minHeap
                -> Add cost of popped item to totalCost.
                -> Repeat till all nodes are visited.


        Walkthrough of the code
            -> Created a custom pair class to keep distance and nodes mapped.
            -> Given the vertices, created a weighted map
                -> Connect all points to each other and keep track of weights.
            -> Start of Prim's Algorithm
                -> Maintain a min heap
                    -> This is used to keep track of minimum weighted edge.
                    -> Min heap is to used to track edges with weights.
                        -> Minimum weight edge will be on the top
                        -> In our greedy approach
                            -> We start with the minimum weight vertex
                            -> Traverse all the edges of it
                                -> If they are not visited, add them to minHeap

                -> While iterating the min heap, we know minimum weight item is on top
                    -> We fetch top item of min heap
                    -> Add cost to result
                    -> Iterate the adjList of the current node whose weight we just added
                        -> If items are not visited, add them to minHeap
                -> Stop, when we have visited all the items. (n - 1)

            -> Time Complexity
                -> We are adding items to minHeap, O(LogN) time to add an item where N is size of minHeap so far.
                -> While iterating a node, we traverse each of it's adjacency node
                    -> We keep check of visited too
                    -> So, iterating through each node and it's neighbors will take O(V + E)

                -> Overall TC = O(V+E * LogN);

    class Pair {

        public Integer a;
        public Integer b;

        public Pair(Integer first, Integer second) {
            this.a = first;
            this.b = second;
        }
    }


    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        int cost = 0;

        // Node mapped to other nodes and distance to those nodes.
        Map<Integer, List<Pair>> adj = new HashMap<>();

        for(int i = 0; i<n; i++) {

            adj.putIfAbsent(i, new ArrayList<Pair>());
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j = i+1; j<n; j++) {

                adj.putIfAbsent(j, new ArrayList<Pair>());
                int x2 = points[j][0];
                int y2 = points[j][1];

                int distance = Math.abs(x2-x1) + Math.abs(y2-y1);

                adj.get(i).add(new Pair(distance, j));
                adj.get(j).add(new Pair(distance, i));
            }
        }

        // Prim's Algorithm
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>( (a,b) -> a[0] - b[0]);

        minHeap.add(new int[] {0, 0});

        while(visited.size() != n) {

            int[] curr = minHeap.poll();
            int dist = curr[0];
            int node = curr[1];

            if(visited.contains(node)) {
                continue;
            }

            cost+=dist;
            visited.add(node);

            for(Pair p: adj.get(node)) {
                if(visited.contains(p.b) != true) {

                    minHeap.add(new int[] {p.a, p.b});
                }
            }
        }

        return cost;

    }

     */
}
