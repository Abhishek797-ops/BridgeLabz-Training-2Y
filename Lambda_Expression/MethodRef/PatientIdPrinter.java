import java.util.Arrays;
import java.util.List;

class Patient {
    private int patientId;

    public Patient(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }
}

public class PatientIdPrinter {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new Patient(101),
                new Patient(102),
                new Patient(205),
                new Patient(310));

        System.out.println("Printing all Patient IDs:");

        patients.stream()
                .map(Patient::getPatientId)
                .forEach(System.out::println);
    }
}