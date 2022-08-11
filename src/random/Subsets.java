package random;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void subsets(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {
        System.out.println("-----Before-----");
        System.out.println(result + " --> " + temp + " --> " + index);
        result.add(new ArrayList<>(temp));
        System.out.println("-----After-----");
        System.out.println(result + " --> " + temp + " --> " + index);
        System.out.println();

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            subsets(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
