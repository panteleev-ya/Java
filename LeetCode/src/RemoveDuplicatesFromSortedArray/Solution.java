package RemoveDuplicatesFromSortedArray;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Собираем в двустороннюю очередь все отсортированные уникальные числа
        ArrayDeque<Integer> uniques = new ArrayDeque<>();
        uniques.addLast(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (uniques.peekLast() != nums[i]) {
                uniques.addLast(nums[i]);
            }
        }

        // Заполняем ими nums, возвращаем их количество
        int size = uniques.size();
        for (int i = 0; i < size; i++) {
            nums[i] = uniques.pollFirst();
        }

        return size;
    }
}
