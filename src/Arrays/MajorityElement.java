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
   nums---  2	      2	        1	      1	        1	      2	         2
   index--  p-0	      p-1	    p-2	      p-3	    p-4	      p-5	     p-6
    value--- 2	  value-2   value-2	   value-2	  value-1	 value-1     value-2
    point--- 1	  point-2   point-1	   point-0	  point-1	 point-0	 point-1

    it will reset and take fresh values as 1	already exisiting is 1 so 1+1=2		finally return position value
*/
    /*
  ---initialze count as 0 and candidate with nums[0]
  ---traverse till length
  ----if the count is'0' reset nums[value] and set count as 1
  ---else if  nums value matches candidate increment cunt
  ---decremnt count
  ---finally return count
     */

    //time--o[n]

    private int majorityElem(int[] nums) {
        int candidate=nums[0];
        int count=1;
      for(int i=0;i<nums.length;i++){
          if(count ==0){
              candidate=nums[i];
              count=1;
          } else if (nums[i]==candidate) {
              count++;
          }else
              count--;
      }
      return candidate;
    }
}
