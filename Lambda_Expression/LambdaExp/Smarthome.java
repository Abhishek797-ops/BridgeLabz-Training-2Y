@FunctionalInterface
interface LightActivation {
    void activate();
}

class SmartLight {
    private String location;

    public SmartLight(String location) {
        this.location = location;
    }

    public void setTrigger(String triggerType, LightActivation behavior) {
        System.out.println(location + " light responding to trigger: " + triggerType);
        behavior.activate();
    }
}

public class Smarthome {
    public static void main(String[] args) {
        SmartLight livingRoomLight = new SmartLight("Living Room");

        LightActivation motionActivation = () -> System.out.println("Pattern: Bright white light ON.");
        livingRoomLight.setTrigger("Motion Detected", motionActivation);

        System.out.println("--------------------");

        LightActivation timeActivation = () -> System.out.println("Pattern: Warm, dim light ON.");
        livingRoomLight.setTrigger("Time is 7 PM", timeActivation);

        System.out.println("--------------------");

        LightActivation voiceActivation = () -> System.out.println("Pattern: Pulsing blue party mode ON.");
        livingRoomLight.setTrigger("Voice Command 'Party Time'", voiceActivation);
    }
}