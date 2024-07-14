import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape", "melon");

        // Convert each word to uppercase using map
        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // Print the converted list
        System.out.println("Original List: " + words);
        System.out.println("Uppercase List: " + upperCaseWords);
    }
}

