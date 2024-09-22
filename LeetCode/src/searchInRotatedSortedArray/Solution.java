package searchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;

            // Case 1: find target
            if (nums[middle] == target) {
                return middle;
            }

            if (nums[left] <= nums[middle]) {
                // Case 2: subarray on middle's left is sorted
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // Case 3: subarray on middle's right is sorted
                if (nums[middle] < target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }
}