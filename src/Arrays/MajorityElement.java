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
   nums
2     2     1     1     1     2     2

index
0     1     2     3     4     5     6

candidate
2     2     2     2     1     1     2

count
1     2     1     0     1     0     1

    it will reset and take fresh values as 1	already exisiting is 1 so 1+1=2		finally return position value
*/
    /*
  ---initialize count as 0 and candidate as nums[0]
---traverse from index 0 till length
----if count is '0' then set candidate as nums[index] and set count as 1
---else if nums[index] value matches candidate then increment count
---else decrement count
---finally return candidate
     */

    //time--o[n]

    private int majorityElem(int[] nums) {
        int candidate=nums[0];
        int count=1;
      for(int i=1;i<nums.length;i++){
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
