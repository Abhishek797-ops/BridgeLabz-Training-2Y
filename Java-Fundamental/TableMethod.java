public class TableMethod {
    public void customMethod() {

    }

    public static void table(int num1) {
        for (int i = 1; i < 11; i++) {
            System.out.println(num1 * i);
        }

    }

    public static void main(String[] args) {
        TableMethod obj = new TableMethod();
        obj.customMethod();
        TableMethod.table(5);

    }
}
