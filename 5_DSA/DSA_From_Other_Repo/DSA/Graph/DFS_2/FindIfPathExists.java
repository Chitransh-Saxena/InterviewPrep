package com.DSA.Graph.DFS_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIfPathExists {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];

        for(int[] edge: edges) {

            int v1 = edge[0];
            int v2 = edge[1];

            // Since it is bi-direction mapping, add this to map accordingly
            graph.computeIfAbsent(v1, val -> new ArrayList<Integer>()).add(v2);
            graph.computeIfAbsent(v2, val -> new ArrayList<Integer>()).add(v1);
        }

        // We start traversing from the source node.
        return canReach(graph, source, destination, visited);
    }

    private boolean canReach(Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited) {

        if(source == destination) {
            return true;
        }

        if(!visited[source]) {

            for(Integer v: graph.get(source)) {
                return canReach(graph, v, destination, visited);
            }
        }

        return false;
    }
}
