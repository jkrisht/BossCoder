package curriculum.C12;

public class FindPivotInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 9, 10, -1, 1, 4, 5};
        System.out.println(findPivot(arr));
        System.out.println(smartSolution(arr));
    }

    public static int smartSolution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return 0;
        }

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid >= 1 && arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int findPivot(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return 0;
        }

        int low = 0, high = arr.length - 1;
        int pivot = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid - 1 >= 0 && mid + 1 <= arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid + 1;
                } else if (arr[mid - 1] < arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                break;
            }
        }

        return pivot;
    }
}
