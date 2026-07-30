package Sorting;

import org.junit.jupiter.api.Test;
import java.util.*;

public class MinPlatform {

    @Test
    public void test1() {
      int[]  arr = {1000, 935, 1100};
    int[] dep = {1200, 1240, 1130};
    System.out.println(minPlatform(arr, dep)); // expect 3
    }



    @Test
    public void test2() {
        int[]  arr = {900, 1235, 1100};
        int[] dep = {1000, 1240, 1200};
        System.out.println(minPlatform(arr, dep)); // expect 3

    }
    /*
    Time	Event	Platforms Needed	Max Platforms
 935Train arrives	1	1
1000	Train arrives	2	2
1100	Train arrives	3	3
1130	Train departs	2	3
1200	Train departs	1	3
1240	Train departs	0	3
     */

    /*
* GOAL: find the minimum number of platforms needed so no train waits

* sort arr[] (arrival times) in ascending order
* sort dep[] (departure times) in ascending order

* initialize i = 0 (pointer into sorted arr[])
* initialize j = 0 (pointer into sorted dep[])
* initialize platformsNeeded = 0, maxPlatforms = 0

* while i < n AND j < n:
    * if arr[i] <= dep[j]:
        - a new train is arriving at or before the next departure
        - (using <= here means: if arrival time equals departure time,
           we treat the arrival as needing its own platform RIGHT NOW,
           per the problem's rule that equal times can't share)
        - increment platformsNeeded
        - update maxPlatforms = max(maxPlatforms, platformsNeeded)
        - move i forward (this arrival has been processed)

    * else:
        - a train is departing before the next arrival
        - decrement platformsNeeded (a platform just freed up)
        - move j forward (this departure has been processed)

* return maxPlatforms
*/
    private int minPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platformsNeeded=0,maxPlatforms=0;
       int n= arr.length;
       int m= dep.length;
       int i=0,j=0;
        while(i<n&&j<m){
            if(arr[i]<=dep[j]){
                platformsNeeded++;
                maxPlatforms=Math.max(maxPlatforms, platformsNeeded);
                i++;
            }else{
                platformsNeeded--;
                j++;
            }
        }
return maxPlatforms;
    }
}
