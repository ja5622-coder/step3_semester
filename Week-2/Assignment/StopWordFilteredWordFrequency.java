import java.util.HashMap;
import java.util.Map;

public class StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase and remove punctuation
        String cleanedText = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        // Split into words
        String[] words = cleanedText.split("\\s+");

        // Stop words
        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> frequency = new HashMap<>();

        // Count words
        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        // Sort entries by frequency in descending order
        frequency.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry ->
                    System.out.println(entry.getKey() + ": " + entry.getValue())
                );
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
