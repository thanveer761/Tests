package Arrays;

import org.junit.jupiter.api.Test;
import java.util.*;

public class MoveZeroes {

    @Test
    public void test1(){
        int[] nums={0,1,0,3,12};
       int[] op= moveZeroes(nums);
       System.out.println(Arrays.toString(op));

    }

    public int[] moveZeroes(int[] nums){
        int left=0;
        for (int right = 1; right < nums.length ; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }

        return nums;
    }
}
