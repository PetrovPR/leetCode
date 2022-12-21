package org.leetcode;

import java.util.*;

public class FindIfPathExistsInGraph_1971 {

    public static boolean validPathDFS(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[n];

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        return dfs(graph, seen, source, destination);
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode, int destination) {
        if (currNode == destination) {
            return true;
        }
        if (!seen[currNode]) {
            seen[currNode] = true;
            for (int nextNode : graph.get(currNode)) {
                if (dfs(graph, seen, nextNode, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<>()) .add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }

        // Store all the nodes to be visited in 'queue'.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (currNode == destination) {
                return true;
            }

            // For all the neighbors of the current node, if we haven't visit it before,
            // add it to 'queue' and mark it as visited.
            for (int nextNode : graph.get(currNode)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        return false;
    }


    public boolean validPathUnionFind(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);


        for (int i = 0; i < edges.length; i++) {
            unionFind.union(edges[i][0], edges[i][1]);
        }

        return unionFind.isUnion(source, destination);
    }

    public class UnionFind {

        int[] id;

        int[] size;

        public UnionFind(int capacity) {
            id = new int[capacity];
            size = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }


        private void union(int a, int b) {

            int rootA = root(a);
            int rootB = root(b);

            if (size[rootA] > size[rootB]) {
                id[rootB] = id[rootA];
                size[rootA] += size[rootB];
                size[rootB] = 0;
            } else {
                id[rootA] = id[rootB];
                size[rootB] += size[rootA];
                size[rootA] = 0;
            }
        }

        private boolean isUnion(int a, int b) {
            return root(a) == root(b);
        }


        private int root(int r) {
            int root = r;
            while (id[root] != root) {
                root = id[root];
            }
            //path compression
            while (root != id[r]) {
                int tmp = id[r];
                id[r] = root;
                r = tmp;
            }
            return root;
        }

    }
}
