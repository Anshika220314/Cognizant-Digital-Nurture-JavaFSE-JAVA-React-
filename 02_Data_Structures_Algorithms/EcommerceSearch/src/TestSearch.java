import java.util.Arrays;

public class TestSearch {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P101", "Laptop", "Electronics"),
            new Product("P102", "Smartphone", "Electronics"),
            new Product("P103", "Headphones", "Audio"),
            new Product("P104", "Backpack", "Accessories"),
            new Product("P105", "Running Shoes", "Footwear")
        };

        String target = "Headphones";

        // Test Linear Search
        System.out.println("--- Running Linear Search ---");
        Product result1 = SearchAlgorithms.linearSearch(products, target);
        System.out.println("Result: " + (result1 != null ? result1 : "Not Found"));

        // Sort array before running Binary Search
        Arrays.sort(products);

        // Test Binary Search
        System.out.println("\n--- Running Binary Search (Sorted Array) ---");
        Product result2 = SearchAlgorithms.binarySearch(products, target);
        System.out.println("Result: " + (result2 != null ? result2 : "Not Found"));
    }
}