package SDESheet;

public class kadanes {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        int sum = 0,maxi = nums[0];
        for(int i = 0;i < nums.length;i++) {
            int num = nums[i];
            sum += num;

            if (sum > maxi) maxi = sum;
            if (sum < 0) sum = 0;
        }

        return maxi;
    }
}
