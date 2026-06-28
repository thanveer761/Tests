package Arrays;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SumOfUniqueElements {

    @Test
    public void test1(){
        int[] nums={1,2,3,2};
      int op1=  sumOfUniqueElements1(nums);
      System.out.println(op1);
        int op2=  sumOfUniqueElements2(nums);
        System.out.println(op2);
    }

    /*pseudocode: (bruteforce) O[N^2]
    * initialize count as 0
    * pick each number one by one (which is i)
    * assume it is unique
    * compare it with every other number (which is j)
    * if same value found at different position
        - mark it as not unique
        - stop comparing, no need to check further
    * After comparing with everyone,
         - if still unique, add it to count
    * repeat steps 2-6 for every number
    * return count


     */
    public int sumOfUniqueElements1(int[]nums){
          int count =0;
        for (int i = 0; i < nums.length ; i++) {
            boolean isUnique=true;
            for (int j = 0; j < nums.length; j++) {
                if(i!=j&&nums[i]==nums[j]){
                    isUnique=false;
                    break;
                }
            }
            if(isUnique) count+=nums[i];
        }
           return count;
    }

     /*pseudocode: (using hashset optimized) O[N]
    * create two sets as seen and duplicates
    * for every number in array:
       - if already seen add to duplicates
      - else add to seen
    * for  every number in seen:
       - if not in duplicates
       -add to count
    * return count
     */
     public int sumOfUniqueElements2(int[]nums){

         Set<Integer> seen= new HashSet<>();
         Set<Integer> duplicates= new HashSet<>();
         for (int n: nums){
             if(seen.contains(n)){
                 duplicates.add(n);
             }else{
                 seen.add(n);
             }
         }
         int count =0;
         for (int n: seen){
             if(!duplicates.contains(n)){
                count+=n;
             }
         }
         return count;
     }

}
