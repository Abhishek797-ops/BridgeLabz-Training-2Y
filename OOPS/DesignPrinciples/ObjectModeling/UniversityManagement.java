import java.util.*;

class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }

    void assignCourse(Course c) {
        System.out.println(name + " teaches " + c.name);
    }
}

class UniversitySystem {
    List<Student> students = new ArrayList<>();
    List<Professor> professors = new ArrayList<>();
    List<Course> courses = new ArrayList<>();
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Neha");
        Professor p = new Professor("Prof. Arjun");
        Course c = new Course("Physics");
        s.enroll(c);
        p.assignCourse(c);
    }
}
