package org.leetcode;

import sun.util.resources.es.CurrencyNames_es;

import java.util.HashMap;
import java.util.Map;

public class NumIslands_200 {

    public static void main(String[] args) {
        String[][] islands = new String[][]{
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"}
        };

        System.out.println(numIslands(islands));

    }

    public static int numIslands(String[][] grid) {
        int numberOfRows = grid.length;
        int numberOfWidth = grid[0].length;
        int result = 0;
        int numberOfElements = numberOfRows * numberOfWidth;
        UnionFind unionFind = new UnionFind(numberOfElements);
        for (int i = 0; i < numberOfRows; i++) {
            for(int j = 0; j < numberOfWidth; j++) {
                if (j + 1 < numberOfWidth && grid[i][j].equals(grid[i][j+1])) {
                    unionFind.union(i*numberOfWidth + j, i * numberOfWidth + j+1);
                }
                if (i + 1 < numberOfRows && grid[i][j].equals(grid[i + 1][j])) {
                    unionFind.union(i*numberOfWidth + j, (i+ 1) * numberOfWidth + j);
                }

                if (grid[i][j].equals("0")) {
                    unionFind.nullSize(i*numberOfWidth + j);
                }
            }

        }
        for(int a = 0; a < unionFind.size.length; a ++) {
            if (unionFind.size[a] > 0 ) {
                result++;
            }
        }
      return result;
    }

    private static class UnionFind {
        int numberOfIslands;
        int id[];
        int size[];
        public UnionFind(int numberOfElements) {
             numberOfIslands = numberOfElements;
             id = new int[numberOfElements];
             size = new int[numberOfElements];

             for(int i = 0; i < numberOfElements; i ++) {
                 id[i] = i;
                 size[i] = 1;
             }
        }
        public int find(int p) {
            int root = p;
            //search the root of the graph
            while(root != id[root]) {
                root = id[root];
            }
            //path compression
            while (root != id[p]) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootB == rootA) return;

            if (size[rootA] < size[rootB]) {
                size[rootB] += size[rootA];
                id[rootA] = rootB;
                size[rootA] = 0;
            } else {
                size[rootA] += size[rootB];
                id[rootB] = rootA;
                size[rootB] = 0;
            }
            numberOfIslands--;
        }

        public void nullSize(int i) {
            size[i] = 0;
        }
    }

}

