import java.util.Scanner;

interface Billable {
    double calculateAmount();
}

class Student implements Billable {
    double amount;

    Student(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount * 0.90;
    }
}

class Staff implements Billable {
    double amount;

    Staff(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount * 0.95;
    }
}

class Guest implements Billable {
    double amount;

    Guest(double amount) {
        this.amount = amount;
    }

    public double calculateAmount() {
        return amount + 10;
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Billable bill = switch (type) {
                case "STUDENT" -> new Student(amount);
                case "STAFF" -> new Staff(amount);
                case "GUEST" -> new Guest(amount);
                default -> throw new IllegalArgumentException("Invalid customer type");
            };

            double finalAmount = bill.calculateAmount();

            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}