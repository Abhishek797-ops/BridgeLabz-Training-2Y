import java.util.*;

// Patient (Encapsulation)
class Patient {
    private String name;
    private int age;
    private String medicalHistory;
    private Doctor doctor; // Association

    public Patient(String name, int age, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void assignDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

// Doctor
class Doctor {
    String name;
    String specialization;
    List<Patient> patients = new ArrayList<>();

    Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void addPatient(Patient p) {
        patients.add(p);
        p.assignDoctor(this);
    }

    public List<Patient> getPatients() {
        return patients;
    }
}

// Department (Composition)
class Department {
    String name;
    List<Doctor> doctors = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}

// Hospital (Composition)
class Hospital {
    String name;
    List<Department> departments = new ArrayList<>();

    Hospital(String name) {
        this.name = name;
    }

    public void addDepartment(Department d) {
        departments.add(d);
    }

    // Fetch patients by doctor
    public List<Patient> getPatientsByDoctor(Doctor doctor) {
        return doctor.getPatients();
    }
}

// ✅ Entry point
public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Department cardiology = new Department("Cardiology");
        Department neurology = new Department("Neurology");

        Doctor doc1 = new Doctor("Dr. Sharma", "Cardiologist");
        Doctor doc2 = new Doctor("Dr. Verma", "Neurologist");

        cardiology.addDoctor(doc1);
        neurology.addDoctor(doc2);

        hospital.addDepartment(cardiology);
        hospital.addDepartment(neurology);

        Patient p1 = new Patient("Ravi", 30, "Heart issue");
        Patient p2 = new Patient("Anita", 45, "Migraine");
        Patient p3 = new Patient("Akash", 55, "Piles");

        doc1.addPatient(p1);
        doc2.addPatient(p2);
        doc1.addPatient(p3);

        System.out.println("Patients of " + doc1.name + ":");
        for (Patient p : hospital.getPatientsByDoctor(doc1)) {
            System.out.println("- " + p.getName() + " (" + p.getMedicalHistory() + ")");
        }
    }
}
