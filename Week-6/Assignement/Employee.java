class Employee {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employee
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for intern
    public Employee(String empId, String empName) {

        // Call the three-argument constructor
        this(empId, empName, 0);

        // Change intern status
        this.isIntern = true;
    }

    // Display employee details
    public void printProfile() {
        System.out.println(empId + " | " + empName
                + " | Rs " + salary
                + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {

        // Permanent employee
        Employee employee1 =
                new Employee("E-101", "Divya", 65000);

        // Intern
        Employee employee2 =
                new Employee("E-102", "Arjun");

        employee1.printProfile();
        employee2.printProfile();
    }
}

