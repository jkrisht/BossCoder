package curriculum.C6;

public class MinimumSwapsAndK {
    public static void main(String[] args) {
        int[] arr = {};
        int K = 3;
        System.out.println(new MinimumSwapsAndK().minSwap(arr, K));
    }

    public int minSwap(int[] arr, int K) {
        int count = 0;

        if (arr == null || arr.length <= 1) {
            return count;
        }

        boolean isGreaterElement = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > K && !isGreaterElement) {
                isGreaterElement = true;
            }

            if (isGreaterElement && arr[i] <= K) {
                count++;
            }
        }

        return count;
    }
}
