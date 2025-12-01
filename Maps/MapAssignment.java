import java.util.*;
import java.util.stream.*;

class Employee {
    String name, dept;
    Employee(String n, String d){ name=n; dept=d; }
    public String toString(){ return name; }
}

public class MapAssignment {
    public static void main(String[] args) {

        String text = "Hello world, hello Java!";
        Map<String,Integer> freq = new HashMap<>();
        for(String w : text.toLowerCase().replaceAll("[^a-z ]","").split(" ")){
            if(w.length()>0) freq.put(w, freq.getOrDefault(w,0)+1);
        }
        System.out.println(freq);

        Map<String,Integer> m1 = new HashMap<>();
        m1.put("A",1); m1.put("B",2); m1.put("C",1);
        Map<Integer,List<String>> inv = new HashMap<>();
        for(String k : m1.keySet()){
            int v = m1.get(k);
            inv.putIfAbsent(v,new ArrayList<>());
            inv.get(v).add(k);
        }
        System.out.println(inv);

        Map<String,Integer> m2 = Map.of("A",10,"B",20,"C",15);
        String maxKey = Collections.max(m2.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(maxKey);

        Map<String,Integer> a = new HashMap<>();
        a.put("A",1); a.put("B",2);
        Map<String,Integer> b = new HashMap<>();
        b.put("B",3); b.put("C",4);
        Map<String,Integer> merged = new HashMap<>(a);
        for(String k : b.keySet()) merged.put(k, merged.getOrDefault(k,0)+b.get(k));
        System.out.println(merged);

        List<Employee> employees = Arrays.asList(
                new Employee("Alice","HR"),
                new Employee("Bob","IT"),
                new Employee("Carol","HR")
        );
        Map<String,List<Employee>> grouped = new HashMap<>();
        for(Employee e : employees){
            grouped.putIfAbsent(e.dept,new ArrayList<>());
            grouped.get(e.dept).add(e);
        }
        System.out.println(grouped);

        Map<String,Double> grades = new HashMap<>();
        grades.put("Aman",85.0);
        grades.put("Riya",90.0);
        grades.put("Karan",70.0);
        grades.put("Aman",95.0);
        grades.remove("Karan");
        TreeMap<String,Double> sortedGrades = new TreeMap<>(grades);
        System.out.println(sortedGrades);

        Map<String,Integer> stock = new HashMap<>();
        stock.put("Pen",20);
        stock.put("Book",10);
        stock.put("Bag",5);
        stock.put("Pen", stock.get("Pen")-5);
        stock.put("Bag", stock.get("Bag")+10);
        if(stock.get("Book")<=0) stock.put("Book",0);
        System.out.println(stock);

        Map<String,Integer> votes = new HashMap<>();
        String[] vlist = {"A","B","A","C","A","B","A","C","A","B"};
        for(String v : vlist) votes.put(v, votes.getOrDefault(v,0)+1);
        String win = Collections.max(votes.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(votes);
        System.out.println(win);

        Map<String,String> books = new HashMap<>();
        books.put("978-1","Java");
        books.put("978-2","Python");
        books.put("978-3","AI");
        if(books.containsKey("978-1")) System.out.println(books.get("978-1"));
        books.remove("978-3");
        TreeMap<String,String> sorted = new TreeMap<>(books);
        System.out.println(sorted);

        String s = "Java is fun and Java is powerful";
        Map<String,Integer> freq2 = new HashMap<>();
        for(String w : s.toLowerCase().split(" ")){
            freq2.put(w,freq2.getOrDefault(w,0)+1);
        }
        System.out.println(freq2);

        Map<String,Integer> attend = new HashMap<>();
        List<String> studs = Arrays.asList("Aman","Riya","Neha","Karan","Sia");
        for(String st : studs) attend.put(st,0);
        List<List<String>> days = Arrays.asList(
                Arrays.asList("Aman","Riya"),
                Arrays.asList("Aman","Neha"),
                Arrays.asList("Riya","Sia"),
                Arrays.asList("Aman","Karan"),
                Arrays.asList("Neha","Sia")
        );
        for(List<String> d : days)
            for(String st : d)
                attend.put(st, attend.get(st)+1);
        for(String st : attend.keySet())
            if(attend.get(st)<2) System.out.println(st);

        Map<String,String> cc = new HashMap<>();
        cc.put("India","Delhi");
        cc.put("USA","Washington");
        cc.put("Japan","Tokyo");
        TreeMap<String,String> ccs = new TreeMap<>(cc);
        System.out.println(ccs);

        Map<String,Integer> courses = new HashMap<>();
        courses.put("CS101",60);
        courses.put("CS102",3);
        courses.put("CS103",10);
        for(String k : courses.keySet())
            if(courses.get(k)>=50) System.out.println(k);
        for(String k : courses.keySet())
            if(courses.get(k)<5) System.out.println(k);

        Map<String,Double> salary = new HashMap<>();
        salary.put("Aman",50000.0);
        salary.put("Riya",65000.0);
        salary.put("Karan",70000.0);
        salary.put("Neha",55000.0);
        salary.put("Tara",72000.0);
        salary.put("Vikram",60000.0);
        salary.put("Aman", salary.get("Aman")*1.10);
        double avg = salary.values().stream().mapToDouble(i->i).average().orElse(0);
        System.out.println(avg);
        double maxSal = Collections.max(salary.values());
        for(String k : salary.keySet())
            if(salary.get(k)==maxSal) System.out.println(k);

        Map<String,Integer> pages = new HashMap<>();
        String[] seq = {"home","about","products","home","products","contact","home"};
        for(String pg : seq) pages.put(pg,pages.getOrDefault(pg,0)+1);
        List<Map.Entry<String,Integer>> list = new ArrayList<>(pages.entrySet());
        list.sort((x,y)->y.getValue()-x.getValue());
        System.out.println(list);
        System.out.println(list.get(0).getKey());

        Map<String,Double> bal = new HashMap<>();
        bal.put("AC1",10000.0);
        bal.put("AC2",5000.0);
        bal.put("AC3",20000.0);
        bal.put("AC1", bal.get("AC1")+2000);
        if(bal.get("AC2")>=6000) bal.put("AC2", bal.get("AC2")-6000);
        List<Map.Entry<String,Double>> sortedBal = new ArrayList<>(bal.entrySet());
        sortedBal.sort((x,y)->Double.compare(y.getValue(),x.getValue()));
        System.out.println(sortedBal);
        System.out.println(sortedBal.subList(0,2));

        LinkedHashMap<String,Double> cart = new LinkedHashMap<>();
        cart.put("Laptop",40000.0);
        cart.put("Mouse",500.0);
        cart.put("Keyboard",700.0);
        System.out.println(cart);
        double total = cart.values().stream().mapToDouble(i->i).sum();
        if(total>5000) total*=0.90;
        System.out.println(total);

        Map<Integer,String> dept = new HashMap<>();
        dept.put(1,"IT");
        dept.put(2,"HR");
        dept.put(3,"IT");
        dept.put(4,"Finance");
        dept.put(2,"Finance");
        Map<String,List<Integer>> rev = new HashMap<>();
        for(Integer id : dept.keySet()){
            String dpt = dept.get(id);
            rev.putIfAbsent(dpt,new ArrayList<>());
            rev.get(dpt).add(id);
        }
        System.out.println(rev);

        Map<String,Map<String,Integer>> scores = new HashMap<>();
        scores.put("Math", Map.of("Aman",90,"Riya",85,"Karan",92));
        scores.put("Science", Map.of("Aman",70,"Riya",95,"Karan",88));
        for(String sub : scores.keySet()){
            Map<String,Integer> st = scores.get(sub);
            String topper = Collections.max(st.entrySet(), Map.Entry.comparingByValue()).getKey();
            System.out.println(sub+" "+topper);
        }
        for(String sub : scores.keySet()){
            Map<String,Integer> st = scores.get(sub);
            double av = st.values().stream().mapToInt(i->i).average().orElse(0);
            System.out.println(sub+" "+av);
        }
        for(String sub : scores.keySet()){
            Map<String,Integer> st = scores.get(sub);
            if(st.values().stream().anyMatch(i->i>90)) System.out.println(sub);
        }
    }
}
