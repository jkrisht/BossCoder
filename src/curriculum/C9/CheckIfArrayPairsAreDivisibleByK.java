package curriculum.C9;

public class CheckIfArrayPairsAreDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(new CheckIfArrayPairsAreDivisibleByK().smartSolution(arr, 10));
    }

    public boolean smartSolution(int[] arr, int k) {
        if (arr == null || arr.length <= 0) {
            return false;
        }

        int[] frequency = new int[k];

        for (int value : arr) {
            value = value % k;
            if (value < 0) {
                value += k;
            }
            frequency[value]++;
        }

        for (int i = 1; i <= k / 2; i++) {
            if (frequency[i] != frequency[k - i]) {
                return false;
            }
        }

        return true;
    }

    public boolean canArrange(int[] arr, int k) {
        if (arr == null || arr.length <= 1) {
            return false;
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if ((arr[i] + arr[j]) % k == 0) {
                    count++;
                }
            }

            if (count >= arr.length / 2) {
                return true;
            }
        }

        return count >= arr.length / 2;
    }
}
