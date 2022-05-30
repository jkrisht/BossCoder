package curriculum.C12;

public class FindFirstOccurence {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 2, 2, 2, 2};
        System.out.println(findFirstOccurance(arr, 2));
    }

    public static int findFirstOccurance(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 && arr[0] == target) {
            return 0;
        }

        int low = 0, high = arr.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                index = mid;
                high = mid - 1;
            } else if (target < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}
