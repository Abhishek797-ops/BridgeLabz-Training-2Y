package OOPS.Constructors;

import java.util.Scanner;

class Circle {
    double radius;

    Circle() {
        this(1.0);
    }

    Circle(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("Default radius: " + c1.radius);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double r = sc.nextDouble();
        Circle c2 = new Circle(r);

        System.out.println("User radius: " + c2.radius);
        sc.close();
    }
}
