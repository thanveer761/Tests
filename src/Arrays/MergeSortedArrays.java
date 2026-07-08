package Arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortedArrays {

    @Test
    public void test1(){
       int[] nums1 = {1,2,3,0,0,0};
       int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
       int[] op= merge(nums1,m,nums2, n);
       System.out.println(Arrays.toString(op));
    }
    @Test
    public void test2(){
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        int[] op= merge(nums1,m,nums2, n);
        System.out.println(Arrays.toString(op));
    }
    /*
    psuedocode:
    ---intialize a pointer as 0
    ---- traverse from index till m+n
    ---assign nums1[j] to nums2[i] and increment i
    ---sort the nums1
    --return nums1
     */
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        for (int j = m; j < m+n ; j++) {
        nums1[j]=nums2[i++];
        }
        Arrays.sort(nums1);
        return nums1;
    }
}
