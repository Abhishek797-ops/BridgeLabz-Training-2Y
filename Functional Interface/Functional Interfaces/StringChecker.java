import java.util.function.Function;

public class StringChecker {
    public static void main(String[] args) {
        Function<String, Integer> lengthChecker = str -> str.length();
        String message = "Hello Java!";
        System.out.println("Message length: " + lengthChecker.apply(message));
    }
}
