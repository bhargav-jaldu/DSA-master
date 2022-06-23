package OOPS.Abstraction;


// we are hiding internal details -- Abstraction
// we cannot create object for abstract classes

// If class contain abstract method then that class also should be declared as abstract
abstract class Vehicle {
    int no_of_tyres;

    abstract void start(); // methods without body is known as abstract methods

     void isFullTank() { // we can also have concert methods therefore 0 - 100% abstraction

     }
}

// If a regular class is inheriting abstract class
// then the class must have to implement all the abstract methods of abstract parent class
class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Starts With Key");
    }
}

class Scooter extends Vehicle {

    @Override
    void start() {
        System.out.println("Starts With Kick");
    }
}

public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        car.start();

        Scooter scooter = new Scooter();
        scooter.start();
    }
}
