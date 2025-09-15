package OOPS.Constructors.InstanceVsClass;

class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Amit", "Car");
        Vehicle v2 = new Vehicle("Riya", "Bike");

        System.out.println(v1.ownerName + " " + v1.vehicleType + " " + registrationFee);
        System.out.println(v2.ownerName + " " + v2.vehicleType + " " + registrationFee);

        Vehicle.updateRegistrationFee(7000);
        System.out.println("Updated Fee: " + v1.ownerName + " " + v1.vehicleType + " " + registrationFee);
        System.out.println("Updated Fee: " + v2.ownerName + " " + v2.vehicleType + " " + registrationFee);
    }
}
