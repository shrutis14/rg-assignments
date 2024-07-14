import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Lambda expression to print each name in uppercase
        System.out.println("Using Lambda Expression:");
        names.forEach(name -> System.out.println(name.toUpperCase()));

        // Method reference to print each name in uppercase
        System.out.println("\nUsing Method Reference:");
        names.forEach(MethodReferenceExample::printUpperCase);
    }

    // Static method to print a string in uppercase
    public static void printUpperCase(String str) {
        System.out.println(str.toUpperCase());
    }
}
