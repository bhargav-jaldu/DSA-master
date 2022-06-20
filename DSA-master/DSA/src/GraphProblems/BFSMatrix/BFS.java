package GraphProblems.BFSMatrix;


import java.util.*;

class Pair {
    int row, col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class BFS {
    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        f(grid, visited);
    }

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static void f(int[][] grid, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int x = queue.peek().row;
            int y = queue.peek().col;
            queue.poll();

            System.out.print(grid[x][y] + ", ");

//            travel adj directions
            for(int i = 0;i < 4;i++) {
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];

                if (isValid(adjx, adjy, visited)) {
                    queue.add(new Pair(adjx, adjy));
                    visited[adjx][adjy] = true;
                }
            }
        }
    }

    static boolean isValid(int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= visited.length || y >= visited[0].length) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        return true;
    }
}
