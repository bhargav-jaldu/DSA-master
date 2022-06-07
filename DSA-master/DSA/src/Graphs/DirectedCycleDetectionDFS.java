package Graphs;

import java.util.*;

public class DirectedCycleDetectionDFS {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        int vertices = 9;
        for(int i = 0;i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        graph(1, 2);
        graph(2, 3);
        graph(3, 6);
        graph(3, 4);
        graph(4, 5);
        graph(6, 5);

        graph(7, 8);
        graph(8, 9);
        graph(9, 7);

        System.out.println(cycleCheck(vertices));
    }

    private static void graph(int u, int v) {
        graph.get(u).add(v);
    }

    private static boolean cycleCheck(int vertices) {
        int[] visited = new int[vertices + 1];
        int[] dfsVisited = new int[vertices + 1];

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                if (check(i, visited, dfsVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean check(int vertex, int[] visited, int[] dfsVisited) {
        visited[vertex] = 1;
        dfsVisited[vertex] = 1;

        for(int it: graph.get(vertex)) {
            if (visited[it] == 0) {
                if (check(it, visited, dfsVisited)) return true;
            }
            else if (dfsVisited[it] == 1 && visited[it] == 1) {
                return true;
            }
        }

        dfsVisited[vertex] = 0;
        return false;
    }
}
