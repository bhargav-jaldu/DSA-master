import java.util.*;

public class Infosys {
    public static void main(String[] args) {

        int n = 6;
        List<String> arr = new ArrayList<>();
        arr.add("abcd");
        arr.add("efgh");
        arr.add("ijkl");
        arr.add("lmno");
        System.out.println(LPSPS(n, arr));
    }

    public static int LPSPS(int N, List<String> arr) {
//        write your code here
        int[] longestSubLen = new int[arr.size()];

        for(int i = 0;i < arr.size();i++) {
            String s = arr.get(i);

            StringBuilder sb = new StringBuilder(s);
            sb.reverse();

            int[][] dp = new int[s.length()][s.length()];
            for(int[] row: dp) {
                Arrays.fill(row, -1);
            }

            longestSubLen[i] = memo(s, sb.toString(), s.length() - 1, s.length() - 1, dp);
        }

        String s = "";
        for(int i = 0;i < longestSubLen.length;i++) {
            s += longestSubLen[i];
        }

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        int ans = memo(s, sb.toString(), s.length() - 1, s.length() - 1, dp);
        return ans;
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
