import java.util.Scanner;

abstract class Appliance {
    protected double hours;
    static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }
}

interface SaverMode {
    double calculateSaverUnits();
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 1500.0;
    }

    @Override
    public double calculateSaverUnits() {
        return calculateUnits() * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 500.0;
    }

    @Override
    public double calculateSaverUnits() {
        return calculateUnits() * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0].toUpperCase();
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length > 2
                    && input[2].equalsIgnoreCase("SAVER");

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    continue;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units;

            if (saver) {
                units = ((SaverMode) appliance).calculateSaverUnits();
            } else {
                units = appliance.calculateUnits();
            }

            double cost = units * 8.0;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}