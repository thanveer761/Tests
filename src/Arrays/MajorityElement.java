package Arrays;

import org.junit.jupiter.api.Test;

public class MajorityElement {

    @Test
    public void test1() {
        int[] nums = {2,2,1,1,1,2,2};
       int op= majorityElem(nums);
        System.out.println(op);
    }
    /*
    2	      2	        1	      1	        1	     2	         2
    p-0	      p-1	    p-2	      p-3	    p-4	     p-5	     p-6
    value-2	  value-2   value-1	  value-1	value-1	 value-2     value-2
    point-1	  point-2   point-1	  point-1	point-2	 point-1	 point-0

    it will reset and take fresh values as 1	already exisiting is 1 so 1+1=2		finally return position value
*/
    /*
   - initialize position as 0 and count as 1
   - traverse the array starting from index 1
    - if value at position is not equal to value at current index:
        - decrement count
        - if count becomes 0:
            - set position to current index
            - reset count to 1
    - else:
        - increment count
- finally, return the value at position
     */

    //time--o[n]

    private int majorityElem(int[] nums) {
        int position=0;
        int count=1;
        for (int j = 0; j < nums.length ; j++) {
            if(nums[position]!=nums[j]){
               count--;
               if(count==0){
                   position=j;
                   count=1;
               }
            }
            else {
                count++;
        }
        }
       return nums[position];
    }
}
