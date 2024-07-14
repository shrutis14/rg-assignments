// Functional Interface
interface Calculator {
    int calculate(int a, int b);
}

public class Lambda {
    public static void main(String[] args) {
        // Lambda expression to implement the calculate method of Calculator interface
        Calculator add = (a, b) -> a + b;

        // Using the lambda expression to perform addition
        int result = add.calculate(10, 5);
        System.out.println("Result: " + result); // Output: Result: 15
    }
}
