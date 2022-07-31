import java.util.Scanner;

public class B2
{
    static int f(int[] arr, int n)
    {
        int pos_sum = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] > 0)
                pos_sum += arr[i];

        if (pos_sum % 2 == 0)
            return pos_sum;

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (arr[i] % 2 != 0) {
                if (arr[i] > 0)
                    ans = ans>(pos_sum - arr[i]) ? ans:(pos_sum - arr[i]);
                else
                    ans = ans>(pos_sum + arr[i]) ? ans:(pos_sum + arr[i]);
            }
        }

        return ans;
    }

    public static void main(String s[])
    {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[] a = new int[M];
        for(int i = 0;i < M;i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(f(a, a.length));
    }
}
