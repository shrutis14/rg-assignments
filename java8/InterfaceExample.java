// Example interface with default and static methods
interface Shape {
    // Abstract method
    void draw();

    // Default method
    default void info() {
        System.out.println("This is a shape.");
    }

    // Static method
    static void printType() {
        System.out.println("Shape interface");
    }
}

// Implementation of Shape interface
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    // Override default method if needed
    @Override
    public void info() {
        System.out.println("This is a circle.");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Circle circle = new Circle();

        // Calling abstract method
        circle.draw();  // Output: Drawing Circle

        // Calling default method
        circle.info();  // Output: This is a circle.

        // Calling static method from interface
        Shape.printType();  // Output: Shape interface
    }
}
