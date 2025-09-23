import java.util.*;

class Doctor {
    String name;

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient p) {
        System.out.println(name + " consulting " + p.name);
    }
}

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Hospital {
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();
}

public class Main {
    public static void main(String[] args) {
        Doctor d = new Doctor("Dr. Raj");
        Patient p = new Patient("Amit");
        d.consult(p);
    }
}
