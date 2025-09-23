import java.util.*;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class Department {
    String name;

    Department(String name) {
        this.name = name;
    }
}

class University {
    String name;
    List<Department> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();

    University(String name) {
        this.name = name;
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void addFaculty(Faculty f) {
        faculties.add(f);
    }
}

public class Main {
    public static void main(String[] args) {
        University u = new University("Global Univ");
        Department d1 = new Department("Science");
        u.addDepartment(d1);
        u.addFaculty(new Faculty("Dr. Smith"));
        System.out.println(u.name + " has dept " + d1.name);
    }
}
