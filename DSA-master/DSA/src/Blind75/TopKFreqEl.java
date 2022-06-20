package Blind75;

import java.util.Arrays;

public class TopKFreqEl {
    public static void main(String[] args) {
        int[] nums = {-1, -1};
        int k = 1;
        f(nums, k);
    }

    static void f(int[] nums, int k) {
        int[] freq = new int[(int)Math.pow(10, 5) + 1];

        for(int i = 0;i < nums.length;i++) {
            int el = nums[i];

            if (freq[el] == 0) {
                freq[el] = 1;
            }
            else {
                freq[el]++;
            }
        }

        int[] ans = new int[k];
        int max = 0;
        int index = 0;
        while(index < k) {
            for(int i = 0;i < freq.length;i++) {
                if (freq[i] > max) {
                    max = i;
                    ans[index] = i;
                    freq[i] = 0;
                    index++;
                }
            }
        }

        System.out.println(Arrays.toString(ans));
    }
}
