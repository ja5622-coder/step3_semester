import java.util.*;

public class FirstNonRepeatingCharacter {

    static char findFirstNonRepeatingChar(String text) {

        // HashMap stores character and its frequency
        HashMap<Character, Integer> frequency = new HashMap<>();

        // Count frequency of each character
        for (char ch : text.toCharArray()) {

            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Scan from left to right
        for (char ch : text.toCharArray()) {

            if (frequency.get(ch) == 1) {
                return ch;
            }
        }

        // Return special value if no character is found
        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println(
                    "First Non-Repeating Character: '" + result + "'"
            );
        }

        sc.close();
    }
}