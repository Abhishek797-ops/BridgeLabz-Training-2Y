public class CustomMethod {
    public void customMethod() {
        System.out.println("Hello from Method");
    }

    public static int sum(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

    public static void main(String[] args) {
        CustomMethod obj = new CustomMethod();
        obj.customMethod();
        int result = CustomMethod.sum(20, 70);
        System.out.println(result);
    }

}
