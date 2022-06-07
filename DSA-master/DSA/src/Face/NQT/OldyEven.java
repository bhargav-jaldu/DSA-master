package Face.NQT;

public class OldyEven {
    public static void main(String[] args) {
        int num = 5476;
        oldyEven(num);
    }

    private static void oldyEven(int num) {

        boolean b = false;
        int temp = num;
        int odd = 0, even = 0;
        while(temp != 0) {
            int rem = temp % 10;
            if (b) {
                odd = odd + rem;
                b = false;
            }
            else {
                even = even + rem;
                b = true;
            }
            temp = temp / 10;
        }

        System.out.println(Math.abs(even - odd));
    }
}
