package BinarySearch;


import org.junit.jupiter.api.Test;

public class SearchRotatedSortedArrayII {

        @Test
        public void test1() {
            int[] nums = {2, 5, 6, 0, 0, 1, 2};
            int target = 0;
            System.out.println(search(nums, target)); // expect true
        }

        @Test
        public void test2() {
            int[] nums = {2, 5, 6, 0, 0, 1, 2};
            int target = 3;
            System.out.println(search(nums, target)); // expect false
        }

        @Test
        public void test3() {
            // ambiguous duplicates case: forces the left==mid==right branch
            int[] nums = {1, 0, 1, 1, 1};
            int target = 0;
            System.out.println(search(nums, target)); // expect true
        }
        /*
* GOAL: determine if target exists in a rotated sorted array that may contain duplicates

* initialize left = 0, right = n - 1

* while left <= right:
    * mid = (left + right) / 2
    * if nums[mid] == target: return true

    * if nums[left] == nums[mid] AND nums[mid] == nums[right]:
        - can't determine which half is sorted (ambiguous due to duplicates)
        - shrink search space conservatively from both ends
        - left = left + 1, right = right - 1

    * else if nums[left] <= nums[mid]:
        - left half [left..mid] is normally sorted
        - if target is within [nums[left], nums[mid]):
            - search left half: right = mid - 1
        - else:
            - search right half: left = mid + 1

    * else:
        - right half [mid..right] is normally sorted
        - if target is within (nums[mid], nums[right]]:
            - search right half: left = mid + 1
        - else:
            - search left half: right = mid - 1

* if loop ends without finding target, return false
*/

        public boolean search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return true;
                }

                if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                    left++;
                    right--;
                } else if (nums[left] <= nums[mid]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            return false;
        }
    }

