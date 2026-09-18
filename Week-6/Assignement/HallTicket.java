class HallTicket {

    String studentName;
    int seatNumber;

    // Constructor
    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        // Create first object
        HallTicket priya =
                new HallTicket("Priya", 0);

        // Second variable points to SAME object
        HallTicket copy = priya;

        // Change through second variable
        copy.seatNumber = 45;

        // Create a separate object
        HallTicket separate =
                new HallTicket("Priya", 45);

        System.out.println(
                "Priya's seatNumber (via first variable): "
                        + priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println(
                "separate == priya: " + (separate == priya));
    }
}
