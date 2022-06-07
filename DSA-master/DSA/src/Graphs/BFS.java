package Graphs;

import java.util.*;

public class BFS {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {

        int vertices = 7;
        for (int i = 0; i < vertices + 1; i++) {
            graph.add(new ArrayList<>());
        }

        graph(1, 2);
        graph(2, 3);
        graph(3, 5);
        graph(5, 6);
        graph(7, 2);
        graph(4, 6);

        bfs(vertices);
    }

    private static void graph(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static void bfs(int vertices) {
        int[] visited = new int[vertices + 1];

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] != 1) {
                f(i, visited);
            }
        }
    }

    private static void f(int i, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = 1;
        queue.add(i);

        while(!queue.isEmpty()) {
            int el = queue.poll();
            System.out.print(el + " , ");

            for(int j: graph.get(el)) {
                if (visited[j] == 0) {
                    visited[j] = 1;
                    queue.add(j);
                }
            }
        }
    }

    private static void printGraph() {
        for (int i = 0; i < graph.size(); i++) {
            ArrayList<Integer> g = graph.get(i);
            System.out.print(i + " => ");
            for(int j: g) {
                System.out.print(j + " , ");
            }
            System.out.println();
        }
    }
}
