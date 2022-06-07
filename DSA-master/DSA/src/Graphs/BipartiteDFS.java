package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteDFS {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {

        int vertices = 7;
        for (int i = 0; i < vertices + 1; i++) {
            graph.add(new ArrayList<>());
        }

//        graph(1, 2);
//        graph(2, 3);
//        graph(3, 5);
//        graph(5, 7);
//        graph(7, 2);
//        graph(5, 6);
//        graph(6, 7);

        graph(1, 2);
        graph(2, 3);
        graph(3, 5);
        graph(5,7);
        graph(7, 2);
        graph(4, 6);

        System.out.println(bipartite(vertices));
    }

    private static void graph(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static boolean bipartite(int vertices) {
        int[] colors = new int[vertices + 1];
        Arrays.fill(colors, -1);

        for(int i = 1;i < colors.length;i++) {
            if (colors[i] == -1) {
                if (!check(i, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean check(int vertex, int[] colors) {

        for(int it: graph.get(vertex)) {
            if (colors[it] == -1) {
                colors[it] = 1 - colors[vertex];
                if (!check(it, colors)) {
                    return false;
                }
            }
            else if (colors[it] == colors[vertex]) {
                return false;
            }
        }

        return true;
    }
}
