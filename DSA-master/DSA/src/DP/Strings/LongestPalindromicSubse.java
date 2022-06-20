package DP.Strings;

// https://leetcode.com/problems/longest-palindromic-subsequence/

import java.util.Arrays;

public class LongestPalindromicSubse {
    public static void main(String[] args) {
        String s = "cbbd"; // given

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(memo(s, sb.toString(), s.length() - 1, s.length() - 1, dp));
    }

    static int memo(String s, String t, int ind1, int ind2, int[][] dp) {

        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if (dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        if (s.charAt(ind1) == t.charAt(ind2)) {
            return dp[ind1][ind2] =  1 + memo(s, t, ind1 - 1, ind2 - 1, dp);
        }

        return dp[ind1][ind2] = Math.max(memo(s, t, ind1 - 1, ind2, dp), memo(s, t, ind1, ind2 - 1, dp));

    }
}
