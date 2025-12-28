
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        URLShortener shortener = new URLShortener();

        while (true) {
            System.out.println("\n--- URL Shortener ---");
            System.out.println("1. Shorten URL");
            System.out.println("2. Retrieve Original URL");
            System.out.println("3. Display All URLs");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter original URL: ");
                    String original = sc.nextLine();
                    String shortURL = shortener.shortenURL(original);
                    System.out.println("Shortened URL: " + shortURL);
                }
                case 2 -> {
                    System.out.print("Enter short URL code: ");
                    String code = sc.nextLine();
                    String original = shortener.getOriginalURL(code);
                    if (original != null) System.out.println("Original URL: " + original);
                    else System.out.println("URL not found!");
                }
                case 3 -> shortener.displayAll();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
