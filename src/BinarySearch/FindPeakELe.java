package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindPeakELe {


    @Test
    public void test(){
        int[] nums={1,2,3,1};
        Assertions.assertEquals(2, findPeak(nums));
    }

    @Test
    public void test1(){
        int[] nums={1,2,1,3,5,6,4};
        Assertions.assertEquals(5, findPeak(nums));
    }

    @Test
    public void test3(){
        int[] nums={1,2,3,4,5,6};
        Assertions.assertEquals(5, findPeak(nums));
    }

    @Test
    public void test4(){
        int[] nums={5,4,3,2,1};
        Assertions.assertEquals(0, findPeak(nums));
    }

    public int findPeak(int[] nums){
        if(nums[0]>nums[1]) return 0;
        int last=nums.length-1;
        if(nums[last]>nums[last-1]) return last;
        int low=1, high=last-1;
        while (low<=high){
            int mid= low+(high-low)/2;
            // best case - matching scenario
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid]<nums[mid+1]) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}