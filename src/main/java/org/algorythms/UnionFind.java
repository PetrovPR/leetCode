package org.algorythms;

public class UnionFind {

    int[] size; //size of elements in union fined data structure
    int[] id; // array of elements and theirs roots

    int numberOfComponents;  // total number of union components

    public UnionFind(int sizeOfElements) {
        size = new int[sizeOfElements];
        id = new int[sizeOfElements];
        numberOfComponents =sizeOfElements;

        for (int i =0; i < sizeOfElements; i++) {
            size[i] = 1;
            id[i] = i;
        }
    }

    public int find(int p) {

        //let's find the root of the element
        int root = p;
        while(root != id[root]) {
            root = id[root];
        }

        //pathCompression
        while( root != id[p]) {
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

        numberOfComponents--;
    }

    public Boolean connected(int a, int b) {
        return  find(a) == find(b);
    }

}
