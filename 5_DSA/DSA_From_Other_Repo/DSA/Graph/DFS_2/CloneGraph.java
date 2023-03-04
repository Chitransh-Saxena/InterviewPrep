package com.DSA.Graph.DFS_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // Rec function to clone each node, call the function recursively to add neighbors.
    // Since it is DFS, each neighbor will be cloned, added to map, and it's neighbors will be visited
    public Node dfs(Node curr, Map<Node, Node> map) {

        if(map.containsKey(curr)) {
            return map.get(curr);
        }

        Node newNode = new Node(curr.val);
        map.putIfAbsent(curr, newNode);

        for(Node neighbor: curr.neighbors) {

            newNode.neighbors.add(dfs(neighbor, map));
        }

        return newNode;
    }

    public Node cloneGraph(Node node) {

        if(node == null) {
            return null;
        }

        // Whenever cloning, clone each node, maintain a map for clone reference
        Map<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }
}
