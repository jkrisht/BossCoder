package curriculum.C12;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(findTarget(arr, 3, 0, arr.length - 1));
        System.out.println(findTargetUsingLoop(arr, 9));
    }

    public static int findTarget(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return findTarget(arr, target, start, mid - 1);
        } else {
            return findTarget(arr, target, mid + 1, end);
        }
    }

    public static int findTargetUsingLoop(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 && arr[0] == target) {
            return 0;
        }

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
