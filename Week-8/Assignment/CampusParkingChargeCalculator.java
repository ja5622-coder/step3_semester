import java.util.Scanner;

interface Parking {
    double calculateCharge();
}

class Bike implements Parking {
    int hours;

    Bike(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car implements Parking {
    int hours;

    Car(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return 30 + (hours - 1) * 20.0;
    }
}

class Truck implements Parking {
    int hours;

    Truck(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return Math.max(hours * 50.0, 100.0);
    }
}

public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Parking vehicle = switch (type) {
                case "BIKE" -> new Bike(hours);
                case "CAR" -> new Car(hours);
                case "TRUCK" -> new Truck(hours);
                default -> throw new IllegalArgumentException("Invalid vehicle type");
            };

            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
