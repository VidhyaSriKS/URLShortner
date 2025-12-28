
import java.util.*;

public class URLShortener {
    private Map<String, String> urlMap = new HashMap<>(); // short -> original
    private Map<String, String> reverseMap = new HashMap<>(); // original -> short
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random random = new Random();
    private int SHORT_LENGTH = 6;

    // Generate a unique short URL code
    private String generateShortCode() {
        String code;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < SHORT_LENGTH; i++) {
                sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            }
            code = sb.toString();
        } while (urlMap.containsKey(code));
        return code;
    }

    // Shorten URL
    public String shortenURL(String originalURL) {
        if (reverseMap.containsKey(originalURL)) {
            return reverseMap.get(originalURL);
        }
        String shortCode = generateShortCode();
        urlMap.put(shortCode, originalURL);
        reverseMap.put(originalURL, shortCode);
        return shortCode;
    }

    // Retrieve original URL
    public String getOriginalURL(String shortCode) {
        return urlMap.getOrDefault(shortCode, null);
    }

    // Display all mappings
    public void displayAll() {
        System.out.println("ShortCode -> Original URL");
        for (String code : urlMap.keySet()) {
            System.out.println(code + " -> " + urlMap.get(code));
        }
    }
}

