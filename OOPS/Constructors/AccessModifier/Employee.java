package OOPS.Constructors.AccessModifier;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        Employee e = new Employee(101, "HR", 40000);
        System.out.println(e.employeeID + " " + e.department);

        e.setSalary(50000);

        Manager m = new Manager(102, "IT", 60000, "Team Lead");
        m.showDetails();
    }
}

class Manager extends Employee {
    String role;

    Manager(int employeeID, String department, double salary, String role) {
        super(employeeID, department, salary);
        this.role = role;
    }

    void showDetails() {
        System.out.println(employeeID + " " + department + " " + role);
    }
}
