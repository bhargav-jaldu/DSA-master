package Recursion;

public class Main {
    public static void main(String[] args) {
//        f1(5);

//        System.out.println(fact(5));
//        System.out.println(sum(1342, 0));

//        System.out.println(reverse(143, 0));

        System.out.println(countZeroes(30204, 0));
    }

    static int countZeroes(int num, int ans) {

        if (num == 0) return ans;

        int rem = num % 10;
        if(rem == 0) ans += 1;
        num = num / 10;

        return countZeroes(num, ans);
    }

    static int reverse(int num, int ans) {

        if (num == 0) return ans;

        int rem = num % 10;
        ans = ans * 10 + rem;
        num = num / 10;

        return reverse(num, ans);
    }

    static int sum(int num, int sum) {
        if (num == 0) {
            return sum;
        }

        int rem = num % 10;
        sum += rem;
        num = num / 10;

        return sum(num, sum);
    }

    static int fact(int n) {
        if (n == 1) {
            return 1;
        }

        return n * fact(n - 1);
    }

    static void f1(int n) {
        if (n == 0) {
            return;
        }

        f1(n - 1);
        System.out.println(n);
    }
}
