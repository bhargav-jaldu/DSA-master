package DP;

public class FrogKJumps {
    public static void main(String[] args) {
        int[] weights = {30, 10, 60, 10, 60, 50};
        int k = 4;
        System.out.println(jump(weights.length - 1, weights, k));
    }

    private static int jump(int index, int[] weights, int k) {
        if (index == 0) {
            return 0;
        }

        int minSteps = Integer.MAX_VALUE;
        for(int j = 1;j <= k;j++) {
            if (index - j >= 0) {
                int jump = jump(index - j, weights, k) + Math.abs(weights[index] - weights[index - j]);
                minSteps = Math.min(jump, minSteps);
            }
        }

        return minSteps;
    }
}
