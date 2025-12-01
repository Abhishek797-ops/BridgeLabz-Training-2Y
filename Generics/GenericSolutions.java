import java.util.*;
import java.util.stream.*;

class Box<T> {
    private T value;
    void set(T value) { this.value = value; }
    T get() { return value; }
}

class Pair<T, U> {
    private T first;
    private U second;
    Pair(T f, U s){ first=f; second=s; }
    T getFirst(){ return first; }
    U getSecond(){ return second; }
}

class Fruit {}
class Apple extends Fruit {}
class Mango extends Fruit {}

class FruitBox<T extends Fruit> {
    List<T> items = new ArrayList<>();
    void add(T item){ items.add(item); }
    void display(){ for(T f:items) System.out.println(f.getClass().getSimpleName()); }
}

class Product { double price; Product(double p){ price=p; } double getPrice(){ return price; } }
class Mobile extends Product { Mobile(double p){ super(p);} }
class Laptop extends Product { Laptop(double p){ super(p);} }

class Vehicle {}
class Truck extends Vehicle {}
class Bike extends Vehicle {}

class FleetManager<T extends Vehicle> {
    List<T> list = new ArrayList<>();
    void addVehicle(T v){ list.add(v); }
    void showFleet(){ for(T v: list) System.out.println(v.getClass().getSimpleName()); }
}

abstract class WarehouseItem {}
class Electronics extends WarehouseItem {}
class Groceries extends WarehouseItem {}
class Furniture extends WarehouseItem {}

class Storage<T extends WarehouseItem> {
    List<T> items = new ArrayList<>();
    void add(T item){ items.add(item); }
}

abstract class Category {}
class BookCategory extends Category {}
class ClothingCategory extends Category {}
class GadgetCategory extends Category {}

class MarketplaceProduct<T extends Category> {
    T category;
    double price;
    MarketplaceProduct(T c, double p){ category=c; price=p; }
    double getPrice(){ return price; }
    void setPrice(double p){ price=p; }
}

abstract class CourseType {}
class ExamCourse extends CourseType {}
class AssignmentCourse extends CourseType {}
class ResearchCourse extends CourseType {}

class Course<T extends CourseType>{
    String name;
    T type;
    Course(String n, T t){ name=n; type=t; }
}

interface MealPlan {}
class VegetarianMeal implements MealPlan {}
class VeganMeal implements MealPlan {}
class KetoMeal implements MealPlan {}
class HighProteinMeal implements MealPlan {}

class Meal<T extends MealPlan>{
    T plan;
    Meal(T p){ plan=p; }
}

abstract class JobRole {}
class SoftwareEngineer extends JobRole {}
class DataScientist extends JobRole {}
class ProductManager extends JobRole {}

class Resume<T extends JobRole>{
    T role;
    Resume(T r){ role=r; }
}

public class GenericSolutions {
    public static <T> boolean isEqual(T a, T b){
        return a.equals(b);
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T m = x;
        if(y.compareTo(m) > 0) m = y;
        if(z.compareTo(m) > 0) m = z;
        return m;
    }

    public static double sumNumbers(List<? extends Number> list){
        double sum = 0;
        for(Number n: list) sum += n.doubleValue();
        return sum;
    }

    public static void copyList(List<? super Number> dest, List<? extends Number> src){
        for(Number n: src) dest.add(n);
    }

    public static void printAnimals(List<? extends Animal> animals){
        for(Animal a: animals) System.out.println(a.getClass().getSimpleName());
    }

    public static double calculateTotal(List<? extends Product> items){
        double total=0;
        for(Product p: items) total+=p.getPrice();
        return total;
    }

    public static void displayWarehouse(List<? extends WarehouseItem> items){
        for(WarehouseItem w: items) System.out.println(w.getClass().getSimpleName());
    }

    public static <T extends MarketplaceProduct<?>> void applyDiscount(T p, double percentage){
        double newPrice = p.getPrice() - (p.getPrice()*percentage/100);
        p.setPrice(newPrice);
    }

    public static void showAllCourses(List<? extends CourseType> list){
        for(CourseType c: list) System.out.println(c.getClass().getSimpleName());
    }

    public static <T extends MealPlan> void generatePlan(T meal){
        System.out.println(meal.getClass().getSimpleName());
    }

    public static void showJobRoles(List<? extends JobRole> list){
        for(JobRole r: list) System.out.println(r.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>();
        b1.set(10);
        System.out.println(b1.get());

        Box<String> b2 = new Box<>();
        b2.set("Hello");
        System.out.println(b2.get());

        Box<Double> b3 = new Box<>();
        b3.set(22.5);
        System.out.println(b3.get());

        Pair<String,Integer> p = new Pair<>("Amol",20);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());

        System.out.println(isEqual(10,10));
        System.out.println(maximum(5,10,7));

        FruitBox<Fruit> fb = new FruitBox<>();
        fb.add(new Apple());
        fb.add(new Mango());
        fb.display();

        System.out.println(sumNumbers(Arrays.asList(1,2,3)));
        System.out.println(sumNumbers(Arrays.asList(1.5,2.5,3.2)));

        List<Number> d = new ArrayList<>();
        copyList(d, Arrays.asList(5,10,15));
        System.out.println(d.size());

        List<Dog> dogs = Arrays.asList(new Dog(), new Dog());
        List<Cat> cats = Arrays.asList(new Cat(), new Cat());
        printAnimals(dogs);
        printAnimals(cats);

        List<Product> mob = Arrays.asList(new Mobile(10000), new Mobile(15000));
        System.out.println(calculateTotal(mob));

        Storage<Electronics> st = new Storage<>();
        st.add(new Electronics());
        displayWarehouse(st.items);

        MarketplaceProduct<BookCategory> mp = new MarketplaceProduct<>(new BookCategory(),500);
        applyDiscount(mp,10);
        System.out.println(mp.getPrice());

        List<CourseType> courses = Arrays.asList(new ExamCourse(), new ResearchCourse());
        showAllCourses(courses);

        generatePlan(new VeganMeal());

        List<JobRole> roles = Arrays.asList(new SoftwareEngineer(), new DataScientist());
        showJobRoles(roles);
    }
}

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}
