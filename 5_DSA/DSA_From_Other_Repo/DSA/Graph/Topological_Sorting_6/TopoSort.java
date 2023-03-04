package com.DSA.Graph.Topological_Sorting_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopoSort {

    /*
        Topological Sorting
            -> Given a directed acyclic graph, find the topological order of it
            -> Let's say, node vertex 0 has two vertices connected to it, 1 and 2
            -> { o -> 1, o -> 2}
            -> So, we can say 0 is a job, whose dependencies are 1 and 2
            -> 0 must be traversed and finished before 1 and 2
            -> 1 and 2 or 2 and 1 are same
            -> Since they do not have any other dependency, as long is 0 is before, order of 1 and 2 does not matter

        Course Schedule 2
    */

    int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] ans = new int[V];

        Map<Integer, Integer> inDegreeMap = new HashMap<>();



        return ans;
    }
}
