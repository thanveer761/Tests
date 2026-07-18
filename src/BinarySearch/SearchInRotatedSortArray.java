package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchInRotatedSortArray {

    @Test
    public void test(){
        int[] nums={4,5,6,7,0,1,2};
        int target=0;
        Assertions.assertEquals(4, findInRotatedArr(nums, target));
    }

    @Test
    public void test1(){
        int[] nums={4,5,6,7,0,1,2};
        int target=3;
        Assertions.assertEquals(-1, findInRotatedArr(nums, target));
    }

    @Test
    public void test2(){
        int[] nums={60,70,80,90,100,5,10,20,30,40,50};
        int target=20;
        Assertions.assertEquals(7, findInRotatedArr(nums, target));
    }

    /**
     * intialise two pointers low=0, high=nums.length-1
     * while low and high are not meeting
     *  - compute mid (low+high/2)
     *  - if the nums[mid]==target retrun mid;
     *  - check if the sub array between low, mid is sorted
     *      - nums[low]<=nums[mid] [4,5,6,7]
     *          - check if the target ele is present in that range
     *              if target>=nums[low] && target<=nums[mid]
     *                  - yes , high=mid-1
     *                  - no, low=mid+1
     *     - nums[mid] <= nums[high] check if the right side sub array is sorted
     *          nums[mid]<=nums[high] [0,1,2]
     *              - check if the target is present in the range
     *                  if target>=nums[mid] && target<=nums[high]
     *                      - if yes, low= mid+1;
     *                      - if no, high=mid-1;
     *   return -1;
     *
     *
     *
     * @param nums
     * @param target
     * @return
     */

    public int findInRotatedArr(int[] nums, int target){
        int low=0, high=nums.length-1;
        while (low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<=nums[mid]){
                    high=mid-1;
                }else low=mid+1;
            }else if(nums[mid]<=nums[high]){
                if(target>=nums[mid] && target<=nums[high]){
                    low=mid+1;
                }else high=mid-1;
            }
        }
        return -1;
    }
}