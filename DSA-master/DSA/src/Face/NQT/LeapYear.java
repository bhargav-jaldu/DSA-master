package Face.NQT;

public class LeapYear {
    public static void main(String[] args) {
        int year = 1600;
        boolean b = false;

        if (year % 4 == 0) {

            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    b = true;
                }
                else {
                    b = false;
                }
            }
            else {
                b = true;
            }
        }
        else {
            b = false;
        }

        System.out.println(b);
    }
}
