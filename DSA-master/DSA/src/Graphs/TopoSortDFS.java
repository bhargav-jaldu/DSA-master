package Graphs;

import java.util.*;

public class TopoSortDFS {
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
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                topo(i, stack, visited);
            }
        }

//        print the stack
        while(!stack.isEmpty()) {
            int el = stack.pop();
            System.out.print(el + ", ");
        }
    }

    private static void topo(int vertex, Stack<Integer> stack, boolean[] visited) {
        visited[vertex] = true;

        for(int it: graph.get(vertex)) {
            if (!visited[it]) {
                topo(it, stack, visited);
            }
        }

        stack.push(vertex);
    }
}
