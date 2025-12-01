interface Vehicle {
    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery info not available.");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed() { System.out.println("Speed: 80 km/h"); }
    public void displayBattery() { System.out.println("Battery: 75%"); }
}
