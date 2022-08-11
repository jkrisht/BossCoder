package random;

class GFG {

    static {
        System.out.println("1st static init");
    }

    static {
        System.out.println("2nd static init");
    }

    {
        System.out.println("1st instance init");
    }

    {
        System.out.println("2nd instance init");
    }

    GFG(int x) {
        System.out.println("ONE argument constructor");
    }

    GFG() {
        System.out.println("No argument constructor");
    }

    public static void main(String[] args) {
        new GFG();
        new GFG(8);
    }
}
