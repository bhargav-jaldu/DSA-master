public class HouseRobber {
    public static void main(String[] args) {
        int[] money = {1, 5, 2, 1, 6};

        int[] money1 = new int[money.length - 1];
        int[] money2 = new int[money.length - 1];

        for(int i = 0;i < money.length;i++) {
            if (i != 0) money1[i - 1] = money[i];
            if (i != money.length - 1) money2[i] = money[i];
        }

        int ans1 = f(money1.length - 1, money1);
        int ans2 = f(money2.length - 1, money2);

        System.out.println(Math.max(ans1, ans2));
    }

    static int f(int ind, int[] money) {

        if (ind == 0) return money[ind];
        if (ind < 0) return 0;

        int pick = f(ind - 2, money) + money[ind];
        int notPick = f(ind - 1, money);

        return Math.max(pick, notPick);
    }
}
