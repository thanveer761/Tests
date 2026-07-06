package DuplicateNumbersArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindMaxNumbersInArray {

    @Test
    public void test1() {
        int[] nums = {10, 20, -12,-80,1,2,7,4,90};
          int[] op= findMaxNums(nums);
          System.out.println(Arrays.toString(op));

    }

    private int[] findMaxNums(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
          nums[i]=  Math.abs(nums[i]);
        }
        Arrays.sort(nums);

        return new int[]{nums[nums.length - 1],nums[nums.length - 2],nums[nums.length - 3]};

    }

}
