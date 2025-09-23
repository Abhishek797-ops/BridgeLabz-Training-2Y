package OOPS.Constructors.AccessModifier;

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public static void main(String[] args) {
        Student s = new Student(101, "Rahul", 8.5);
        System.out.println(s.rollNumber + " " + s.name + " " + s.getCGPA());

        s.setCGPA(9.2);
        System.out.println("Updated CGPA: " + s.getCGPA());

        PostgraduateStudent ps = new PostgraduateStudent(102, "Amit", 8.8, "M.Tech");
        ps.showDetails();
    }
}

class PostgraduateStudent extends Student {
    String course;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String course) {
        super(rollNumber, name, CGPA);
        this.course = course;
    }

    void showDetails() {
        System.out.println(rollNumber + " " + name + " " + course);
    }
}
