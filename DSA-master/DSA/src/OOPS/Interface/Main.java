package OOPS.Interface;

// we can achieve multiple inheritance

interface i1 {
    // only public static final variables

    // abstract methods

    void show(); // by default compiler puts abstract

//    we can also create static, default concrete methods in interfaces -- in version - 8
}

interface i2 {
    void display();
}

public class Main implements i1, i2 {

    @Override
    public void show() {
        System.out.println("Interface 1 Show method");
    }

    @Override
    public void display() {
        System.out.println("Interface 2 Display Method");
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.show();
        m.display();
    }
}
