package Face.NQT;

public class SoberWalk {
    public static void main(String[] args) {
        int n = 6;
        walk(n);
    }

    private static void walk(int n) {
        int x = 0, y = 0;

        char ch = 'R';
        while(n > 0) {
            switch(ch) {
                case 'R':
                    x = Math.abs(x) + 10;
                    y = Math.abs(y);
                    ch = 'U';
                    break;
                case 'U':
                    y = y + 20;
                    ch = 'L';
                    break;
                case 'L':
                    x = -(x + 10);
                    ch = 'D';
                    break;
                case 'D':
                    y = -(y);
                    ch = 'R';
                    break;
            }
            n--;
        }
        System.out.println(x + " " + y);
    }
}
