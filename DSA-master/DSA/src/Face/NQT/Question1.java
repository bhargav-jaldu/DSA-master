package Face.NQT;

// sweet seventeen

public class Question1 {
    public static void main(String[] args) {
        String str = "23GF";
        f(str);
    }

    private static void f(String str) {
        int len = str.length();
        int digit = len - 1;
        int base = 17;
        int ans = 0;

        for(int i = 0;i < str.length();i++) {
            char ch = str.charAt(i);

            boolean f = Character.isDigit(ch);

            if (f) {
                int num = Integer.parseInt(ch + "");
                ans += ((Math.pow(base, digit)) * num);
            }
            else if (ch >= 65 && ch <= 90) {
                int num = ch - 55;
                ans += ((Math.pow(base, digit)) * num);
            }
            else if (ch >= 97 && ch <= 122) {
                int num = ch - 87;
                ans += ((Math.pow(base, digit)) * num);
            }
            digit--;
        }

        System.out.println(ans);
    }
}
