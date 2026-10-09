import java.util.Scanner;

interface Bonus {
    double calculateBonus();
}

class FullTime implements Bonus {
    String name;
    double salary;

    FullTime(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime implements Bonus {
    String name;
    double salary;

    PartTime(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern implements Bonus {
    String name;
    double salary;

    Intern(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Bonus employee = switch (type) {
                case "FULLTIME" -> new FullTime(name, salary);
                case "PARTTIME" -> new PartTime(name, salary);
                case "INTERN" -> new Intern(name, salary);
                default -> throw new IllegalArgumentException("Invalid employee type");
            };

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", name, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);

        sc.close();
    }
}