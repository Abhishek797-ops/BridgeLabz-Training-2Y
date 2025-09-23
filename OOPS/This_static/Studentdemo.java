class Student {
    private static String universityName = "ABC University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", Grade: " + grade);
        }
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Karan", "A");
        Student s2 = new Student(102, "Meera", "B");
        s1.displayStudentDetails();
        s2.displayStudentDetails();
        Student.displayTotalStudents();
    }
}
