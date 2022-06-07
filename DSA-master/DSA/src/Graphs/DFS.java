package Graphs;

import java.util.*;

public class DFS {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {

        int vertices = 7;
        for (int i = 0; i < vertices + 1; i++) {
            graph.add(new ArrayList<>());
        }

        graph(1, 2);
        graph(2, 3);
        graph(3, 5);
        graph(5, 7);
        graph(7, 2);
        graph(4, 6);

        dfs(vertices);
    }

    private static void graph(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static void dfs(int vertices) {
        boolean[] visited = new boolean[vertices + 1];
        for(int i = 1;i < visited.length;i++) {
            if (!visited[i]) {
                f(i, visited);
            }
        }
    }

    private static void f(int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " , ");
        ArrayList<Integer> list = graph.get(i);
        for(int it: list) {
            if (!visited[it]) {
                f(it, visited);
            }
        }
    }
}
