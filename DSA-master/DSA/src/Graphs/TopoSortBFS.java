package Graphs;

import java.util.*;

public class TopoSortBFS {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        int vertices = 6;

        for(int i = 0;i < vertices;i++) {
            graph.add(new ArrayList<>());
        }

        graph(5, 0);
        graph(4, 0);
        graph(4, 1);
        graph(5, 2);
        graph(2, 3);
        graph(3, 1);

        topoSort(vertices);
    }

    private static void graph(int u, int v) {
        graph.get(u).add(v);
    }

    private static void topoSort(int vertices) {
        int[] indegree = new int[vertices];

        for(int i = 0;i < vertices;i++) {
            for(int it: graph.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < vertices;i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + ", ");

            for(int it: graph.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
    }
}
