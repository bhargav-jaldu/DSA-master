package Graphs;

// used to find min spanning tree

import java.util.*;

class Node {
    int vertex, weight;
    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Prims {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void main(String[] args) {
        int vertices = 5;
        for(int i = 0;i < vertices;i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Node(1, 2));
        graph.get(0).add(new Node(3, 6));

        graph.get(1).add(new Node(0, 2));
        graph.get(1).add(new Node(4, 5));
        graph.get(1).add(new Node(3, 8));
        graph.get(1).add(new Node(2, 3));

        graph.get(2).add(new Node(1, 3));
        graph.get(2).add(new Node(4, 7));

        graph.get(3).add(new Node(0, 6));
        graph.get(3).add(new Node(1, 8));

        graph.get(4).add(new Node(1, 5));
        graph.get(4).add(new Node(2, 7));

        prims(vertices);
    }

    static void prims(int vertices) {
        int[] key = new int[vertices];
        boolean[] mst = new boolean[vertices];
        int[] parent = new int[vertices];

        for(int i = 0;i < vertices;i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }

        key[0] = 0;

        for(int i = 0;i < vertices - 1;i++) {
            int u = 0;
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < vertices;j++) {
                if (key[j] < min && !mst[j]) {
                    min = key[j];
                    u = j;
                }
            }

            mst[u] = true;

            for(Node it: graph.get(u)) {
                int vertex = it.vertex;
                int weight = it.weight;

                if (weight < key[vertex] && !mst[vertex]) {
                    parent[vertex] = u;
                    key[vertex] = weight;
                }
            }
        }

        for(int i = 1;i < vertices;i++) {
            System.out.println(i + " ki parent " + parent[i]);
        }
    }
}
