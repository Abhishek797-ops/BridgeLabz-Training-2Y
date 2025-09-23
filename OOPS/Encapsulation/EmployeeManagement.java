abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double s) {
        baseSalary = s;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID:" + employeeId + " Name:" + name + " Salary:" + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String dept);

    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    public double calculateSalary() {
        return getBaseSalary();
    }

    public void assignDepartment(String dept) {
        department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private String department;

    public PartTimeEmployee(int id, String name, double ratePerHour, int hours) {
        super(id, name, ratePerHour);
        hoursWorked = hours;
    }

    public double calculateSalary() {
        return getBaseSalary() * hoursWorked;
    }

    public void assignDepartment(String dept) {
        department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee[] emps = {
                new FullTimeEmployee(1, "Alice", 60000),
                new PartTimeEmployee(2, "Bob", 200, 30)
        };
        for (Employee e : emps)
            e.displayDetails();
    }
}
