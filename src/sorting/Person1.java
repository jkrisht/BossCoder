package sorting;

import java.util.HashMap;
import java.util.Map;

public abstract class Person1 {
    public void display() {
        System.out.println("dis p1");
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(1, "One");
        map.put(3, "Three");
        map.put(2, "Two");
        map.remove(2);
        map.replace(1, "one");
        map.replace(3, "Three", "three");
        double price = 90;
        System.out.println("Total: " + price);
    }
}

class Student extends Person1 {
    public void display() {
        System.out.println("Dis S");
    }
}
