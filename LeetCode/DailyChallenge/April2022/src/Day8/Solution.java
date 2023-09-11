package Day8;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int k = 3;
//        int[] nums = {4, 5, 8, 2};
        int[] nums = {};
        KthLargest obj = new KthLargest(k, nums);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
    public static class KthLargest {
        ArrayList<Integer> list;
        int k;
        int lastAddedVal;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.list = new ArrayList<>(nums.length);
            Arrays.sort(nums);
            for (int num: nums) {
                this.list.add(num);
            }
        }

        public int add(int val) {
            lastAddedVal = val;
            if (list.isEmpty()) {
                list.add(val);
            } else if (val <= list.get(0)) {
                list.add(0, val);
            } else if (val >= list.get(list.size() - 1)) {
                list.add(val);
            } else {
                list.add(binarySearchIndex(0, list.size() - 1), val);
            }
            return list.get(list.size() - k);
        }

        public int binarySearchIndex(int begin, int end) {
            // Если в диапазоне только два числа - вставляем между ними
            // при этом end сдвинется на один вправо и станет (end + 1)
            if (end - begin == 1) {
                return end;
            }

            // Находим границы левого и правого диапазонов
            int mid = begin + (end - begin) / 2;

            // Выбираем тот диапазон, в котором должно оказаться новое число
            if (lastAddedVal < list.get(mid)) {
                return binarySearchIndex(begin, mid);
            } else {
                return binarySearchIndex(mid, end);
            }
        }
    }
}