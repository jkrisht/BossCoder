package curriculum.C11;

public class FindSetBitLocation {
    public static void main(String[] args) {
        System.out.println(new FindSetBitLocation().getBitLocation(12));
    }

    public int getBitLocation(int n) {

        for (int i = 1; i <= 128; i++) {
            if ((n >> (i-1) & 1) == 1) {
                return i;
            }
        }

        return 0;
    }
}
