package Stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    @Test
    public void test1() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2))); // expect [-1, 3, -1]
    }

    @Test
    public void test2() {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2))); // expect [3, -1]
    }
    /*
* GOAL: for each number in nums1, find its next greater element within nums2

* build a map: number -> its next greater element in nums2

* initialize an empty stack

* traverse nums2 from right to left (pointer i from n-1 down to 0)
    * while stack is NOT empty AND stack.peek() <= nums2[i]:
        - pop the stack (this candidate can never be useful again,
          since nums2[i] is closer and bigger)

    * if stack is empty:
        - map[nums2[i]] = -1 (no next greater element found)
    * else:
        - map[nums2[i]] = stack.peek() (closest valid greater element)

    * push nums2[i] onto the stack

* build result array of size nums1.length
* traverse nums1, for each number look up map[number] and store it in result

* return result
*/

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());

            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}