package SDESheet;

public class SortColors {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {

        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high) {
            int num = nums[mid];
            if (num == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if (num == 1) {
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
