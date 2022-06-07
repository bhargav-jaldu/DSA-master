package GraphProblems;


import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class FindMinMoves {
    public static void main(String[] args) {
        int start = 2, end = 100;
        int[] arr = {2, 5, 10};
        System.out.println(findMinMoves(start, end, arr));
    }

    private static int findMinMoves(int start, int end, int[] arr) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));

        while(!queue.isEmpty()) {
            int first = queue.peek().first;
            int steps = queue.peek().second;
            queue.poll();

            if (first == end) return steps;

            for(int i = 0;i < arr.length;i++) {
                int dest = arr[i] * first;
                if (dest <= end) {
                    queue.add(new Pair(dest, steps + 1));
                }
            }
        }

        return -1;
    }
}
