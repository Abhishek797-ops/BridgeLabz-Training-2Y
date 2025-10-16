// File: Vehicle.java
public abstract class Vehicle {
    // --------- Encapsulation ------------
    private String vehicleNumber;
    private String model;
    private double fuelLevel;
    private double speed;

    public Vehicle(String vehicleNumber, String model) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.fuelLevel = 0;
        this.speed = 0;
    }

    // Getters / Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        } else {
            System.out.println("Fuel level must be between 0 and 100");
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed >= 0) {
            this.speed = speed;
        } else {
            System.out.println("Speed must be positive");
        }
    }

    // Abstract methods
    public abstract void startEngine();

    public abstract void stopEngine();

    public abstract String fuelEfficiency();

    // --------- Compile-time Polymorphism (Method Overloading) ------------
    public void refuel(double liters) {
        System.out.println("Refueling " + liters + " liters of fuel");
        setFuelLevel(Math.min(100, getFuelLevel() + liters));
    }

    public void refuelByPercentage(double percentage) {
        System.out.println("Refueling " + percentage + "% of tank");
        setFuelLevel(Math.min(100, getFuelLevel() + percentage));
    }

    public void refuel(String fuelType) {
        System.out.println("Refueling with fuel type: " + fuelType);
        // special handling could go here
    }
}

// --------- Inheritance ------------
class Car extends Vehicle {
    public Car(String vehicleNumber, String model) {
        super(vehicleNumber, model);
    }

    @Override
    public void startEngine() {
        System.out.println("Car " + getVehicleNumber() + " engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car " + getVehicleNumber() + " engine stopped");
    }

    @Override
    public String fuelEfficiency() {
        return "Car fuel efficiency: 15 km/l";
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, String model) {
        super(vehicleNumber, model);
    }

    @Override
    public void startEngine() {
        System.out.println("Truck " + getVehicleNumber() + " engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Truck " + getVehicleNumber() + " engine stopped");
    }

    @Override
    public String fuelEfficiency() {
        return "Truck fuel efficiency: 8 km/l";
    }
}

class Motorbike extends Vehicle {
    public Motorbike(String vehicleNumber, String model) {
        super(vehicleNumber, model);
    }

    @Override
    public void startEngine() {
        System.out.println("Motorbike " + getVehicleNumber() + " engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Motorbike " + getVehicleNumber() + " engine stopped");
    }

    @Override
    public String fuelEfficiency() {
        return "Motorbike fuel efficiency: 35 km/l";
    }
}

// --------- Demo / Runtime Polymorphism ------------
class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("C123", "Sedan"),
                new Truck("T456", "Heavy Duty"),
                new Motorbike("M789", "Sport")
        };

        for (Vehicle v : vehicles) {
            v.startEngine(); // runtime polymorphism
            System.out.println(v.fuelEfficiency()); // runtime polymorphism
            v.refuel(20); // method overloading
            v.refuelByPercentage(30);
            v.refuel("Diesel");
            v.stopEngine();
            System.out.println("-------------------------------");
        }
    }
}
