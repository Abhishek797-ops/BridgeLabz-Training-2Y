package OOPS.Constructors;

import java.util.Scanner;

class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1000;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateCost() {
        return rentalDays * costPerDay;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter car model: ");
        String model = sc.nextLine();
        System.out.print("Enter rental days: ");
        int days = sc.nextInt();

        CarRental rental = new CarRental(name, model, days);
        System.out.println("Customer: " + rental.customerName);
        System.out.println("Car: " + rental.carModel);
        System.out.println("Total cost: " + rental.calculateCost());

        sc.close();
    }
}
