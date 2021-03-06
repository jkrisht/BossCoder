package curriculum.C13;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/
public class FindAllNumbersDisappearedInArray {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new FindAllNumbersDisappearedInArray().findDisappearedNumbers(nums));
    }

    /*
    For each value in the array mark its presence by making the number negative at that place in array
    eg. if you hae array [3,1,4,1] for 3, i will go to index 2 and make its value negative ie. now nums[2] becomes -4. present array: [3,1,-4,1]
    for 1, i will go to index 0 and make its value negative ie. now nums[0] becomes -3. present array: [-3,1,-4,1]
    for 4, (take abs value), i will go to index 3 and make its value negative ie. now nums[3] becomes -1. present array: [-3,1,-4,-1]
    for 1 take abs value), i will go to index 0 as it is already -ve do nothing. present array: [-3,1,-4,-1]
    At last I will have [-3,1,-4,-1]. now i will iterate over the array, whichever idx has positive value that number will not be in the array so as we have nums[1]>0 so 2 is not in the list
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return List.of(0);
        }

        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                index = (nums[i] * -1) - 1;
            } else {
                index = nums[i] - 1;
            }

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }
}
