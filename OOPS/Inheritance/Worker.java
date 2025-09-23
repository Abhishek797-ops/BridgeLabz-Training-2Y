interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " cooks food.");
    }
}

class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " serves customers.");
    }
}

public class Main {
    public static void main(String[] args) {
        Worker chef = new Chef("Ramesh", 1);
        Worker waiter = new Waiter("Suresh", 2);

        chef.performDuties();
        waiter.performDuties();
    }
}
