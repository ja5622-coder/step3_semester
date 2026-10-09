import java.util.Scanner;

interface ElectricityBill {
    double calculateBill();
}

class SingleRoom implements ElectricityBill {
    int units;

    SingleRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom implements ElectricityBill {
    int units;
    int occupants;

    SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom implements ElectricityBill {
    int units;

    ACRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 10.0 + 200;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            ElectricityBill room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(sc.nextInt());
                    break;

                case "SHARED":
                    int units = sc.nextInt();
                    int occupants = sc.nextInt();
                    room = new SharedRoom(units, occupants);
                    break;

                case "AC":
                    room = new ACRoom(sc.nextInt());
                    break;

                default:
                    throw new IllegalArgumentException("Invalid room type");
            }

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
