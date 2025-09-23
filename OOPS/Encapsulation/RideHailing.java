abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return driverName + " - " + vehicleId;
    }
}

interface GPS {
    String getCurrentLocation();

    void updateLocation(String loc);
}

class CarRide extends RideVehicle implements GPS {
    private String loc = "Unknown";

    public CarRide(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return loc;
    }

    public void updateLocation(String l) {
        loc = l;
    }
}

class BikeRide extends RideVehicle implements GPS {
    private String loc = "Unknown";

    public BikeRide(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.6;
    }

    public String getCurrentLocation() {
        return loc;
    }

    public void updateLocation(String l) {
        loc = l;
    }
}

class AutoRide extends RideVehicle implements GPS {
    private String loc = "Unknown";

    public AutoRide(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.8;
    }

    public String getCurrentLocation() {
        return loc;
    }

    public void updateLocation(String l) {
        loc = l;
    }
}

public class RideHailing {
    public static void main(String[] args) {
        RideVehicle[] v = { new CarRide("V1", "Raju", 20), new BikeRide("V2", "Maya", 10),
                new AutoRide("V3", "Suresh", 12) };
        double d = 10;
        for (RideVehicle rv : v)
            System.out.println(rv.getVehicleDetails() + " Fare:" + rv.calculateFare(d));
    }
}
