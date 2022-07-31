package Patterns;

public class Patterns {
    public static void main(String[] args) {

//        pattern1();
//        pattern2();

//        pattern3();
//        pattern1();

        pyramid();
    }

    private static void pyramid() {

        for (int i = 1; i <= 4; i++) {

            for (int j = 4; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }



    }

    private static void pattern3() {
        for (int i = 1; i <= 5 ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern2() {

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern1() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
