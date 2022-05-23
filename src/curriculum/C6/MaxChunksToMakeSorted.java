package curriculum.C6;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,4};
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(arr));
    }

    public int maxChunksToSorted(int[] arr) {
        int result = 0;

        if (arr == null || arr.length < 1) {
            return result;
        }

        int maxValue = arr[0];

        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);

            if (maxValue == i) {
                result++;
            }
        }

        return result;
    }
}
