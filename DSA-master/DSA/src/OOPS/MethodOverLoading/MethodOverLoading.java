package OOPS.MethodOverLoading;

// compile time polymorphism

class Test {

    // same method name, same class, different no of arguments
    void show() {
        System.out.println("1");
    }

    void show(int a) {
        System.out.println("2");
    }

    // By changing the return time of a method, we cannot achieve method overloading
}

public class MethodOverLoading {
    public static void main(String[] args) {

    }

    public static void main(int a) { // we can overload main method 😂

    }
}
