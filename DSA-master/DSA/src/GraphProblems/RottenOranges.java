package GraphProblems;

import java.util.*;

class Node {
    int x, y, time;
    Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };


        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> queue = new LinkedList<>();

        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                int el = grid[i][j];
                if (el == 2) {
                    queue.add(new Node(i,j,0));
                }
            }
        }

        int ans = 0;
        while(!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            int time = queue.peek().time;
            queue.poll();

            ans = Math.max(ans, time);

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for(int i = 0;i < 4;i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];


                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    queue.add(new Node(newX, newY, time + 1));
                }
            }
        }

        boolean b = true;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                int el = grid[i][j];
                if (el == 1) {
                    b = false;
                }
            }
        }

        if (!b) {
            return -1;
        }
        else {
            return ans;
        }
    }
}
