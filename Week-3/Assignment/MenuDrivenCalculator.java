public class MenuDrivenCalculator {

    static void calculate(double a, double b, char operator) {

        switch (operator) {

            case '+':
                System.out.println("Result: " + (a + b));
                break;

            case '-':
                System.out.println("Result: " + (a - b));
                break;

            case '*':
                System.out.println("Result: " + (a * b));
                break;

            case '/':
                if (b == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    System.out.println("Result: " + (a / b));
                }
                break;

            default:
                System.out.println("Invalid operator");
        }
    }

    public static void main(String[] args) {

        double a = 10;
        double b = 4;
        char operator = '+';

        calculate(a, b, operator);
    }
}
