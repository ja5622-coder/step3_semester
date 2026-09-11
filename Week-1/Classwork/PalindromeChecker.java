import java.util.*;

public class PalindromeChecker {

    // Approach 1: Iterative
    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive
    static boolean isPalindromeRecursive(String text) {

        return recursiveCheck(text, 0, text.length() - 1);
    }

    static boolean recursiveCheck(String text, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return recursiveCheck(text, left + 1, right - 1);
    }

    // Approach 3: Array Reversal
    static boolean isPalindromeArrayReversal(String text) {

        char[] characters = text.toCharArray();

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {

            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left++;
            right--;
        }

        String reversed = new String(characters);

        return text.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or text: ");
        String text = sc.nextLine();

        boolean result1 = isPalindromeIterative(text);
        boolean result2 = isPalindromeRecursive(text);
        boolean result3 = isPalindromeArrayReversal(text);

        System.out.println("\n========== RESULTS ==========");

        System.out.println("Iterative: "
                + (result1 ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: "
                + (result2 ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: "
                + (result3 ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}
