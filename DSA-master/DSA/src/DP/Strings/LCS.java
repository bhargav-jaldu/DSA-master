package DP.Strings;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {

        String s1= "abcde";
        String s2= "bdgek";
        System.out.println(f(s1, s2, s1.length() - 1, s2.length() - 1));

        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(memo(s1, s2, s1.length() - 1, s2.length() - 1, dp));
        System.out.println(ans);
    }

//    time: O(2n * 2m)
    static int f(String s1, String s2, int ind1, int ind2) {

        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return 1 + f(s1, s2, ind1 - 1, ind2 - 1);
        }

        return Math.max(f(s1, s2, ind1 - 1, ind2), f(s1, s2, ind1, ind2 - 1));

    }

//    time: O(n * m)
    static String ans = "";
    static int memo(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            ans += s1.charAt(ind1);
            return 1 + memo(s1, s2, ind1 - 1, ind2 - 1, dp);
        }

        return dp[ind1][ind2] = Math.max(memo(s1, s2, ind1 - 1, ind2, dp), memo(s1, s2, ind1, ind2 - 1, dp));
    }
}
