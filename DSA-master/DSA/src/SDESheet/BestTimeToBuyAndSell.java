package SDESheet;

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int smallest = Integer.MAX_VALUE;

        for(int i = 0;i < prices.length;i++) {
            int num = prices[i];

            if (num < smallest) {
                smallest = num;
            }

            int profit = num - smallest;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}
