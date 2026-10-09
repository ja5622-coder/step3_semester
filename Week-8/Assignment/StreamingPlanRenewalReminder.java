import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface SubscriptionPlan {
    LocalDate calculateRenewalDate();
}

class BasicPlan implements SubscriptionPlan {
    String name;
    LocalDate startDate;

    BasicPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan implements SubscriptionPlan {
    String name;
    LocalDate startDate;

    StandardPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan implements SubscriptionPlan {
    String name;
    LocalDate startDate;

    PremiumPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next(), formatter);

            SubscriptionPlan plan = switch (type) {
                case "BASIC" -> new BasicPlan(name, startDate);
                case "STANDARD" -> new StandardPlan(name, startDate);
                case "PREMIUM" -> new PremiumPlan(name, startDate);
                default -> throw new IllegalArgumentException("Invalid plan type");
            };

            System.out.println(
                    name + ": " +
                    plan.calculateRenewalDate().format(formatter)
            );
        }

        sc.close();
    }
}