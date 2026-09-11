public class ATMPinRetry {

    static void atmPinRetry(String correctPin, String[] attempts) {

        int attempt = 0;
        boolean success = false;

        while (attempt < attempts.length && attempt < 3 && !success) {

            if (attempts[attempt].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }

            attempt++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {

        String correctPin = "4821";

        String[] attempts = {
            "1111",
            "4821"
        };

        atmPinRetry(correctPin, attempts);
    }
}
