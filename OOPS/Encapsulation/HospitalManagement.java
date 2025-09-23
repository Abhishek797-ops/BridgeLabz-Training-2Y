abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String id, String name, int age) {
        patientId = id;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPatientDetails() {
        return name + " (" + age + ")";
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String r);

    String viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    private StringBuilder records = new StringBuilder();

    public InPatient(String id, String name, int age, double roomCharge) {
        super(id, name, age);
        this.roomCharge = roomCharge;
    }

    public double calculateBill() {
        return roomCharge + 5000;
    }

    public void addRecord(String r) {
        records.append(r).append(";");
    }

    public String viewRecords() {
        return records.toString();
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private StringBuilder records = new StringBuilder();

    public OutPatient(String id, String name, int age, double fee) {
        super(id, name, age);
        consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String r) {
        records.append(r).append(";");
    }

    public String viewRecords() {
        return records.toString();
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Patient[] pts = { new InPatient("P1", "Amy", 30, 2000), new OutPatient("P2", "Joe", 25, 500) };
        for (Patient p : pts) {
            System.out.println(p.getName() + " Bill:" + p.calculateBill());
            if (p instanceof MedicalRecord)
                ((MedicalRecord) p).addRecord("Checked");
            if (p instanceof MedicalRecord)
                System.out.println("Records:" + ((MedicalRecord) p).viewRecords());
        }
    }
}
