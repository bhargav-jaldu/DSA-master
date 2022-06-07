package Graphs.CycleDetectionBFS;

import java.util.*;

class Node {
    int parent;
    int vertex;
    Node(int vertex, int parent) {
        this.vertex = vertex;
        this.parent = parent;
    }
}

public class CycleDetectionBFS {
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

        System.out.println(cycleDetection(vertices));
    }

    private static void graph(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static boolean cycleDetection(int vertices) {
        boolean[] visited = new boolean[vertices + 1];

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                if (cycle(visited, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean cycle(boolean[] visited, int vertex) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(vertex, -1));
        visited[vertex] = true;

        while(!queue.isEmpty()) {
            int first = queue.peek().vertex;
            int parent = queue.peek().parent;
            queue.poll();

            for(int it: graph.get(first)) {
                if (!visited[it]) {
                    visited[it] = true;
                    queue.add(new Node(it, first));
                }
                else if (it != parent) {
                    return true;
                }
            }
        }

        return false;
    }
}
