package com.DSA.Graph.DFS_2;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];

        path.add(0);

        // Init path with 0th item, and not mark it as visited, send 0th item as source
        dfs(graph, path, ans, 0, visited);
        return ans;
    }

    private void dfs(int[][] graph, List<Integer> path, List<List<Integer>> ans, int i, boolean[] visited) {

        // If we reached last node, we got our destination
        // Number we will add in recursion itself, so here we can get it as it is.
        if(i == graph.length-1) {

            // When we create new ArrayList and add to ans, it stores as a new object which is separate
            // If we do ans.add(path), then any further modification path will modify it's value here too.
            ans.add(new ArrayList<>(path));
            return;
        }

        visited[i] = true;

        for(Integer v: graph[i]) {

            path.add(v);
            dfs(graph, path, ans, v, visited);

            // Backtrack. In order to get all the possible poths.
            path.remove(path.size()-1);
        }
    }
}
