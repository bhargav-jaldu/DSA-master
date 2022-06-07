package Graphs;

import java.util.*;

public class BipartiteBFS {
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
        graph(5, 6);
        graph(6, 7);
//        graph(4, 6);

        System.out.println(bipartite(vertices));
    }

    private static void graph(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static boolean bipartite(int vertices) {
        int[] colors = new int[vertices + 1];
        Arrays.fill(colors, -1);

        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == -1) {
                if (!check(i, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean check(int vertex, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        colors[vertex] = 1;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int it: graph.get(node)) {
                if (colors[it] == -1) {
                    colors[it] = 1 - colors[node];
                    queue.add(it);
                }
                else if (colors[it] == colors[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
