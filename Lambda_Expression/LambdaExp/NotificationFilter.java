import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Alert {
    String severity;
    String message;

    public Alert(String severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    public String getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return "Alert{" + "severity='" + severity + '\'' + ", message='" + message + '\'' + '}';
    }
}

public class NotificationFilter {
    public static void main(String[] args) {
        List<Alert> alerts = new ArrayList<>();
        alerts.add(new Alert("Critical", "Patient 101: Heart rate dropping."));
        alerts.add(new Alert("Info", "Pharmacy restocked on aspirin."));
        alerts.add(new Alert("Warning", "Patient 203: Blood pressure high."));
        alerts.add(new Alert("Critical", "Bed 4: Ventilator pressure alert."));

        Predicate<Alert> isCritical = alert -> alert.getSeverity().equals("Critical");

        List<Alert> criticalAlerts = alerts.stream()
                .filter(isCritical)
                .collect(Collectors.toList());

        System.out.println("Filtered Critical Alerts:");
        criticalAlerts.forEach(System.out::println);
    }
}