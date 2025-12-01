import java.util.*;
import java.util.stream.*;

public class WrapperAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int primitiveInt = 25;
        Integer objInt = Integer.valueOf(primitiveInt);
        System.out.println(primitiveInt);
        System.out.println(objInt);

        Double dobj = 45.67;
        double d1 = dobj;
        int d2 = dobj.intValue();
        System.out.println(d1);
        System.out.println(d2);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(10);
        arr.add(15);
        arr.add(20);
        arr.add(5);
        int sum = 0;
        for(Integer x : arr) sum += x;
        System.out.println(sum);

        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(a.equals(b));

        System.out.println(Integer.parseInt("123"));
        System.out.println(Double.parseDouble("3.14"));
        System.out.println(Boolean.parseBoolean("true"));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Character.isDigit('5'));
        System.out.println(Character.toUpperCase('a'));

        System.out.println(safeParseInt("123"));
        System.out.println(safeParseInt("abc"));
        System.out.println(safeParseInt("45.6"));
        System.out.println(safeParseInt("0"));

        double[] prices = {10.5, 20.0, 35.75, 5.5};
        ArrayList<Double> priceList = new ArrayList<>();
        for(double x : prices) priceList.add(x);
        double max = Collections.max(priceList);
        double avg = priceList.stream().mapToDouble(i -> i).average().orElse(0);
        System.out.println(max);
        System.out.println(avg);

        String text = "Hello123@# World";
        int letters = 0, digits = 0, special = 0;
        for(char ch : text.toCharArray()) {
            if(Character.isLetter(ch)) letters++;
            else if(Character.isDigit(ch)) digits++;
            else if(!Character.isWhitespace(ch)) special++;
        }
        System.out.println(letters);
        System.out.println(digits);
        System.out.println(special);

        String[] cart = {"250", "499", "abc", "99"};
        int total = 0;
        for(String s : cart) {
            try { total += Integer.parseInt(s); }
            catch(Exception e) {}
        }
        System.out.println(total);

        int[] empAges = {21, 35, 40, 19, 50};
        ArrayList<Integer> ageList = new ArrayList<>();
        for(int x : empAges) ageList.add(x);
        System.out.println(Collections.min(ageList));
        System.out.println(Collections.max(ageList));

        System.out.println(isValidAge("20"));
        System.out.println(isValidAge("abc"));
        System.out.println(isValidAge("16"));

        double[] cart2 = {10.5, 20.0, 15.0};
        double total2 = 0;
        for(double x : cart2) total2 += x;
        System.out.println(total2);

        System.out.println(remainingLimit(null));
        System.out.println(remainingLimit(5000.0));

        logSensor(36.5);
        logSensor(Double.valueOf(40.2));

        int[] pr1 = {5, 4, 3};
        ArrayList<Integer> pr2 = new ArrayList<>(Arrays.asList(5, null, 2));
        ArrayList<Integer> all = new ArrayList<>();
        for(int x : pr1) all.add(x);
        all.addAll(pr2);
        double ratingAvg = all.stream().filter(Objects::nonNull).mapToInt(i -> i).average().orElse(0);
        System.out.println(ratingAvg);

        Integer[] scores = {10, null, 20, 15, null, 5};
        int notPlayed = 0;
        int totalScore = 0;
        for(Integer s : scores) {
            if(s == null) notPlayed++;
            else totalScore += s;
        }
        System.out.println(notPlayed);
        System.out.println(totalScore);

        String[] marks = {"85", "95", String.valueOf(88), "null", "abc"};
        ArrayList<Integer> valid = new ArrayList<>();
        for(String s : marks) {
            try {
                Integer v = Integer.valueOf(s);
                valid.add(v);
            } catch(Exception e) {}
        }
        double markAvg = valid.stream().mapToInt(i -> i).average().orElse(0);
        System.out.println(markAvg);

        long t1 = System.currentTimeMillis();
        int[] arr1 = new int[1000000];
        int sum1 = 0;
        for(int i = 0; i < arr1.length; i++) { arr1[i] = i; sum1 += arr1[i]; }
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int sum2 = 0;
        for(int i = 0; i < 1000000; i++) { arr2.add(i); sum2 += arr2.get(i); }
        long t4 = System.currentTimeMillis();

        System.out.println(t2 - t1);
        System.out.println(t4 - t3);
    }

    public static int safeParseInt(String input) {
        try { return Integer.parseInt(input); }
        catch(Exception e) { return -1; }
    }

    public static boolean isValidAge(String age) {
        try { return Integer.parseInt(age) >= 18; }
        catch(Exception e) { return false; }
    }

    public static double remainingLimit(Double limit) {
        if(limit == null) return 0.0;
        return limit;
    }

    public static void logSensor(double temp) {
        Double obj = temp;
        System.out.println(obj);
    }
}
