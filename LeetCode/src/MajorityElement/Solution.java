package MajorityElement;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    private static int randRange(Random rand, int min, int max) {
        // Getting random element from the range [min, max)
        return rand.nextInt(max - min) + min;
    }

    private static int countOccurrences(int[] nums, int randomNum) {
        // Counting appearances of the random element that we have got
        int count = 0;
        for (int num : nums) {
            if (num == randomNum) {
                count++;
            }
        }
        return count;
    }

    public static int majorityElement(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length/2;

        // Because majority element appears >= N/2 times its more likely
        // to get it by getting random element out of all elements, so
        // we take a random element from the array until count of
        // this element in the array will be more than it's half size
        while (true) {
            // O(1) to get random element (50%+ chance to get the right answer)
            int candidate = nums[randRange(rand, 0, nums.length)];

            // O(n) to count how many times it appears in the array
            if (countOccurrences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
}
