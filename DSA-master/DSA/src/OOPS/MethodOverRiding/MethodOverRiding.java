package OOPS.MethodOverRiding;


class Test {
    void show() {
        System.out.println("1");
    }
}

public class MethodOverRiding extends Test {

    void show() { // override
        System.out.println("2");
    }

    public static void main(String[] args) {

    }
}
