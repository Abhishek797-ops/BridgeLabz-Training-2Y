interface Drawable {
    void draw();
}

public class Test {
    public static void main(String[] args) {
        Drawable d = new Drawable() {
            public void draw() {
                System.out.println("Drawing...");
            }
        };
        d.draw();
    }
}