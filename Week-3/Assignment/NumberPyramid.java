public class NumberPyramid {

    static void printNumberPyramid(int n) {

        for (int row = 1; row <= n; row++) {

            for (int i = 1; i <= row; i++) {
                System.out.print(row + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int n = 4;

        printNumberPyramid(n);
    }
}
