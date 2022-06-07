package SDESheet;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(paths(m, n, 0, 0));

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(memo(m, n, 0, 0, dp));
    }

    private static int paths(int m, int n, int row, int col) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (row == m || col == n) {
            return 0;
        }

        int left = paths(m, n, row, col + 1);
        int right = paths(m, n, row + 1, col);

        return left + right;
    }

//    memoization
    private static int memo(int m, int n, int row, int col, int[][] dp) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (row == m || col == n) {
            return 0;
        }

        if (dp[row][col] != -1) return dp[row][col];

        int left = memo(m, n, row, col + 1, dp);
        int right = memo(m, n, row + 1, col, dp);

        return dp[row][col] = left + right;
    }
}
