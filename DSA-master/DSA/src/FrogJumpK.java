public class FrogJumpK {
    public static void main(String[] args) {
        int k = 3;
        int[] heights = {10, 20, 30, 10};
        int ind = heights.length - 1;
        System.out.println(f(ind, k, heights));
    }

    static int f(int ind, int k, int[] heights) {

        if (ind == 0) return 0;


        int mmSteps = Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){
            if(ind-j>=0){
                int jump = f(ind - j, k, heights)+ Math.abs(heights[ind]-
                        heights[ind - j]);
                mmSteps= Math.min(jump, mmSteps);
            }
        }
        return mmSteps;
    }
}
