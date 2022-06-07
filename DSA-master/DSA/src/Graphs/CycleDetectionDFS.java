package Graphs;

import java.util.ArrayList;

public class CycleDetectionDFS {
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

        System.out.println(cycleDetectionDFS(vertices));
    }

    private static void graph(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static boolean cycleDetectionDFS(int vertices) {
        boolean[] visited = new boolean[vertices + 1];

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                if (cycleCheck(i, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean cycleCheck(int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;

        for(int it: graph.get(vertex)) {
            if (!visited[it]) {
                if (cycleCheck(it, vertex, visited)) {
                    return true;
                }
            }
            else if (it != parent) {
                return true;
            }
        }

        return false;
    }
}
