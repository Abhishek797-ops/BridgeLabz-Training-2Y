import java.util.*;

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enroll(Course c) {
        courses.add(c);
        c.students.add(this);
    }

    void showCourses() {
        for (Course c : courses)
            System.out.println(name + " enrolled in " + c.name);
    }
}

class Course {
    String name;
    List<Student> students = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void showStudents() {
        for (Student s : students)
            System.out.println(s.name + " in " + name);
    }
}

class School {
    List<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School();
        Student s1 = new Student("Ravi");
        Course c1 = new Course("Math");
        s1.enroll(c1);
        school.addStudent(s1);
        s1.showCourses();
        c1.showStudents();
    }
}
