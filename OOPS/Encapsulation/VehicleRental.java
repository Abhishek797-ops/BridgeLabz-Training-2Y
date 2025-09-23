abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double r) {
        rentalRate = r;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String no, double rate) {
        super(no, "Car", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 5000;
    }

    public String getInsuranceDetails() {
        return "Car insurance";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String no, double rate) {
        super(no, "Bike", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.6;
    }

    public double calculateInsurance() {
        return 1000;
    }

    public String getInsuranceDetails() {
        return "Bike insurance";
    }
}

class Truck extends Vehicle {
    public Truck(String no, double rate) {
        super(no, "Truck", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5;
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle[] vs = { new Car("KA01", 2000), new Bike("KA02", 800), new Truck("KA03", 4000) };
        for (Vehicle v : vs) {
            System.out.println(v.getType() + " " + v.getVehicleNumber() + " Rent(3d):" + v.calculateRentalCost(3));
            if (v instanceof Insurable)
                System.out.println("Insurance:" + ((Insurable) v).calculateInsurance());
        }
    }
}
