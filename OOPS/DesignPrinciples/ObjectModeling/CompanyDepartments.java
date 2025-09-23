import java.util.*;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    List<Employee> employees = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    void addEmployee(Employee e) {
        employees.add(e);
    }
}

class Company {
    String name;
    List<Department> departments = new ArrayList<>();

    Company(String name) {
        this.name = name;
    }

    void addDepartment(Department d) {
        departments.add(d);
    }
}

public class Main {
    public static void main(String[] args) {
        Company c = new Company("TechCorp");
        Department d = new Department("IT");
        d.addEmployee(new Employee("John"));
        c.addDepartment(d);
        System.out.println(c.name + " has department " + d.name);
    }
}
