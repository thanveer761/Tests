package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindTargetIndex {

    @Test
    public void test(){
        int[] nums={-1,0,3,5,9,12};
        int target=9;
        int op=search(nums,target);
        System.out.println(op);
    }

    @Test
    public void test1(){
        int[] nums={1,2,1,3,5,6,4};
        int target = 2;
        int op=search(nums,target);
        System.out.println(op);
    }

    @Test
    public void test3(){
        int[] nums={-1,0,3,5,9,12};
        int target = 2;
        int op=search(nums,target);
        System.out.println(op);
    }
        public int search(int[] nums, int target) {

            int left = 0, right = nums.length-1;
            while(left <= right) {
                int mid = (left + right)/2;
                if(nums[mid] == target) return mid;
                else if(nums[mid] < target) left = mid+1;
                else right = mid -1;
            }
            return -1;

        }
    }

