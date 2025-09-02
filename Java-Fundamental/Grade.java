import java.util.*;
public class Grade {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String letter = sc.nextLine();
        
        switch (letter) {
            case "A":
                System.out.println("Excellent");
                break;

            case "B":
                System.out.println("Good");
                break;

            case "C":
                System.out.println("Average");
                break;

            case "D":
                System.out.println("Pass");
                break;

            case "F":
                System.out.println("Fail");
                break;
        
            default:
                System.out.println("Invalid Grade");
                break;
        }
    }
    
}
