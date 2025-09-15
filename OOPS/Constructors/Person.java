package OOPS.Constructors;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Rahul", 21);
        Person p2 = new Person(p1);

        System.out.println(p1.name + " " + p1.age);
        System.out.println(p2.name + " " + p2.age);
    }
}
