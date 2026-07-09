package SlidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    @Test
    public void test() {
        int[] fruits = {1,2,3,2,2};
        int op=   totalFruit(fruits);
        System.out.println(op);

    }

   /* -- initialise an empty map called basketCount     (maps fruit type -> count in current window)
            -- initialise left as 0
            -- initialise maxFruits as 0

            -- traverse right from 0 to fruits.length-1

            --   add fruits[right] to basketCount               (increment its count, or insert with count 1 if new)

--   while basketCount has more than 2 distinct fruit types

--     decrement basketCount[fruits[left]] by 1
            --     if basketCount[fruits[left]] becomes 0
            --       remove fruits[left] from basketCount        (that type has fully left the window)
--     increment left                                (shrink window from the left)

--   update maxFruits as max(maxFruits, right - left + 1)

-- return maxFruits

    */
   public int totalFruit(int[] fruits) {
       Map<Integer, Integer> basketCount = new HashMap<>();
       int left = 0;
       int maxFruits = 0;

       for (int right = 0; right < fruits.length; right++) {
           // add fruits[right] into the window
           basketCount.put(fruits[right], basketCount.getOrDefault(fruits[right], 0) + 1);

           // shrink from the left while more than 2 distinct types
           while (basketCount.size() > 2) {
               int leftFruit = fruits[left];
               basketCount.put(leftFruit, basketCount.get(leftFruit) - 1);
               if (basketCount.get(leftFruit) == 0) {
                   basketCount.remove(leftFruit);
               }
               left++;
           }

           maxFruits = Math.max(maxFruits, right - left + 1);
       }

       return maxFruits;
   }
}