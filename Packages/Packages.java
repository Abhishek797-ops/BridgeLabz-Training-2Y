import static java.lang.Math.*;

public class Packages {
    public static void main(String[] args) {
        Student s = new Student("Aman", 101);
        s.display();
        Faculty f = new Faculty("Dr. Rao", "Algorithms");
        f.display();
        Course c = new Course("B.Tech CSE", "Data Structures");
        c.printCourse();
        Book b = new Book("Clean Code", "Robert C. Martin", "ISBN123");
        Member m = new Member(1, "Riya");
        Transaction t = new Transaction(b, m);
        t.issue();
        t.returnBook();
        Employee e = new Employee(201, "Karan", "HR", 50000);
        Payroll p = new Payroll();
        System.out.println("Before bonus: " + e.getSalary());
        System.out.println("After bonus: " + p.calculateBonus(e));
        StudentPerf sp = new StudentPerf("Neha", 78, 85, 90);
        Analyzer an = new Analyzer();
        double avg = an.calculateAverage(sp);
        System.out.println(sp);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + an.findGrade(avg));
        InterestCalculator ic = new InterestCalculator();
        double si = ic.calculateSimpleInterest(10000, 5, 2);
        double ci = ic.calculateCompoundInterest(10000, 5, 2);
        System.out.println("SI: " + si);
        System.out.println("CI: " + ci);
        Base base = new Base();
        base.publicMethod();
        base.protectedMethod();
        base.defaultMethod();
        SalesReport sr = new SalesReport();
        EmployeeReport er = new EmployeeReport();
        sr.printReport();
        er.printReport();
        CompanyReport.printCombined(sr, er);
        System.out.println("Math examples: sqrt(16)=" + sqrt(16) + " pow(2,5)=" + pow(2, 5) + " max(3,7)=" + max(3, 7)
                + " min(3,7)=" + min(3, 7) + " abs(-5)=" + abs(-5));
    }
}

class Student {
    private String name;
    private int roll;

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    void display() {
        System.out.println("Student: " + name + " Roll: " + roll);
    }
}

class Faculty {
    private String name;
    private String subject;

    Faculty(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    void display() {
        System.out.println("Faculty: " + name + " Subject: " + subject);
    }
}

class Course {
    private String program;
    private String courseName;

    Course(String program, String courseName) {
        this.program = program;
        this.courseName = courseName;
    }

    void printCourse() {
        System.out.println("Program: " + program + " Course: " + courseName);
    }
}

class Book {
    private String title;
    private String author;
    private String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String toString() {
        return "Book: " + title + " by " + author + " ISBN:" + isbn;
    }
}

class Member {
    private int id;
    private String name;

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Member: " + name + " ID:" + id;
    }
}

class Transaction {
    private Book book;
    private Member member;
    private boolean issued = false;

    Transaction(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    void issue() {
        issued = true;
        System.out.println("Issued " + book + " to " + member);
    }

    void returnBook() {
        if (issued) {
            issued = false;
            System.out.println("Returned " + book + " from " + member);
        } else {
            System.out.println("No book to return");
        }
    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double s) {
        this.salary = s;
    }

    public String toString() {
        return "Employee: " + name + " ID:" + id + " Dept:" + department + " Salary:" + salary;
    }
}

class Payroll {
    double calculateBonus(Employee e) {
        double bonus = e.getSalary() * 0.10;
        double newSalary = e.getSalary() + bonus;
        e.setSalary(newSalary);
        return newSalary;
    }
}

class StudentPerf {
    private String name;
    private int m1, m2, m3;

    StudentPerf(String name, int m1, int m2, int m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public int getM1() {
        return m1;
    }

    public int getM2() {
        return m2;
    }

    public int getM3() {
        return m3;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Student: " + name + " Marks: " + m1 + "," + m2 + "," + m3;
    }
}

class Analyzer {
    double calculateAverage(StudentPerf s) {
        return (s.getM1() + s.getM2() + s.getM3()) / 3.0;
    }

    String findGrade(double avg) {
        if (avg >= 90)
            return "A+";
        if (avg >= 80)
            return "A";
        if (avg >= 70)
            return "B";
        if (avg >= 60)
            return "C";
        return "F";
    }
}

class InterestCalculator {
    double calculateSimpleInterest(double p, double r, double t) {
        return (p * r * t) / 100.0;
    }

    double calculateCompoundInterest(double p, double r, double t) {
        return p * (pow((1 + r / 100.0), t)) - p;
    }
}

class Base {
    public void publicMethod() {
        System.out.println("public accessible everywhere");
    }

    protected void protectedMethod() {
        System.out.println("protected accessible in package and subclasses");
    }

    void defaultMethod() {
        System.out.println("default accessible in same package");
    }

    private void privateMethod() {
        System.out.println("private accessible only within class");
    }

    public void callPrivate() {
        privateMethod();
    }
}

class SalesReport {
    void printReport() {
        System.out.println("Sales Report: Region A - 10000, Region B - 15000");
    }
}

class EmployeeReport {
    void printReport() {
        System.out.println("Employee Report: Karan - Excellent, Priya - Good");
    }
}

class CompanyReport {
    static void printCombined(SalesReport s, EmployeeReport e) {
        System.out.println("----Company Combined Report----");
        s.printReport();
        e.printReport();
        System.out.println("-------------------------------");
    }
}
