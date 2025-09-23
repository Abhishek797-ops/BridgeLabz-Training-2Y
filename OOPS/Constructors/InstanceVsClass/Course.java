package OOPS.Constructors.InstanceVsClass;

class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "ABC Institute";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java", 3, 5000);
        Course c2 = new Course("Python", 2, 4000);

        System.out.println(c1.courseName + " " + c1.duration + " " + c1.fee + " " + instituteName);
        System.out.println(c2.courseName + " " + c2.duration + " " + c2.fee + " " + instituteName);

        Course.updateInstituteName("XYZ Institute");
        System.out.println("After update: " + c1.courseName + " " + instituteName);
        System.out.println("After update: " + c2.courseName + " " + instituteName);
    }
}
