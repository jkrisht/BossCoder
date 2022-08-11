package random;

class Base {
    public static String s = " Super Class ";

    public Base() {
        System.out.printf("1");
    }
}

public class Derived extends Base {
    public Derived() {
        super();
        System.out.printf("2");
    }

    public static void main(String[] args) {
        Derived obj = new Derived();
        System.out.printf(s);
    }
}

