package org.algorythms;

public class UnionFindTesting {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
        unionFind.union(0, 1);
        unionFind.union(1, 3);
        unionFind.union(1, 5);
        unionFind.union(2, 4);
        unionFind.union(6, 7);
        unionFind.union(4, 6);
        unionFind.union(8, 9);
        System.out.println(unionFind.numberOfComponents);
    }
}
