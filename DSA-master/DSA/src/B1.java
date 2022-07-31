import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int ans = f(a, b);
        System.out.println(ans);
    }

    static int f(int a, int b) {
        int ans = 0;
        for(int i = a;i <= b;i++) {
            int el = i;

            int s = sum(el);
            ans += s;
        }
        return ans;
    }

    static int sum(int el) {
        int sum = 0;
        while(el != 0) {
            int rem = el % 10;
            sum += rem;
            el = el / 10;
        }
        return sum;
    }
}
