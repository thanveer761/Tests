package day1;

import org.junit.jupiter.api.Test;
import java.util.*;

public class RemoveElement {
    @Test
    public void test1() {
        int[] nums = {3,2,2,3};
        int val = 3;

        int[] nums1 = Arrays.copyOf(nums, nums.length); // fresh copy for method 1
        int op = removeElem(nums1, val);
        System.out.println(op);

        int[] nums2 = Arrays.copyOf(nums, nums.length); // fresh copy for method 2
        int op1 = removeElem1(nums2, val);
        System.out.println(op1);
    }

    //brute force
    private int removeElem1(int[] nums, int val) {
        int i=0;
        for (int j = 0; j < nums.length; j++) {
           if(nums[j]!=val){
               nums[i]=nums[j];
               i++;
           }
        }
        return i;
    }
    //two pointer
    private int removeElem(int[] nums, int val) {
        int left=0, right= nums.length-1;
        while(left<=right){
            if(nums[left]==val){
         nums[left]=nums[right];
            right--;
            }else{
               left++;
            }

        }

     return left;
    }
}
