package Graphs.Dijikstras;

import java.util.*;

class Node implements Comparator<Node> {
    int v, weight;

    Node() {}
    Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.weight < o2.weight) {
            return -1;
        }
        if (o1.weight > o2.weight) {
            return 1;
        }
        return 0;
    }
}

public class Dijikstras {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void main(String[] args) {
        int vertices = 5;

        for(int i = 0; i <= vertices;i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(new Node(2, 2));
        graph.get(1).add(new Node(4, 1));

        graph.get(2).add(new Node(1, 2));
        graph.get(2).add(new Node(3, 4));
        graph.get(2).add(new Node(5, 5));

        graph.get(3).add(new Node(2, 4));
        graph.get(3).add(new Node(5, 1));
        graph.get(3).add(new Node(4, 1));

        graph.get(4).add(new Node(1, 1));
        graph.get(4).add(new Node(3, 3));

        graph.get(5).add(new Node(2, 5));
        graph.get(5).add(new Node(3, 1));

        shortestDistance(vertices);
    }

    private static void shortestDistance(int vertices) {
        int src = 1;
        int[] dist = new int[vertices + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, new Node());
        dist[src] = 0;
        pq.add(new Node(1, 0));

        while(pq.size() > 0) {
            Node node = pq.poll();
            int nodeWeight = node.weight;
            int v = node.v;

            for(Node it: graph.get(node.v)) {
                if (dist[v] + it.weight < dist[it.v]) {
                    dist[it.v] = dist[v] + it.weight;
                    pq.add(new Node(it.v, dist[it.v]));
                }
            }
        }


        for(int i = 1;i < dist.length;i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
