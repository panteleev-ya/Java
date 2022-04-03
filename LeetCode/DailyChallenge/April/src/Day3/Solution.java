package Day3;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] arrayOfNums = {
                {1, 2, 3, 4},
                {1, 2, 4, 3},
                {1, 3, 2, 4},
                {1, 3, 4, 2},
                {1, 4, 2, 3},
                {1, 4, 3, 2}
        };
        for (int[] nums: arrayOfNums) {
            nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }

//        int[] nums = {1, 3, 2};
//        nextPermutation(nums);
//        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        // Если длина массива меньше 3 - хардкодим ответ
        if (nums == null || nums.length < 2) {
            return;
        } else if (nums.length == 2) {
            int tmp = nums[0];
            nums[0] = nums[1];
            nums[1] = tmp;
            return;
        }

        // Выбираем сваппэбл элемент - тот, который меньше своего соседа справа
        int swap = nums.length - 2; // ищем с конца
        for (; swap >= 0; swap--) {
            if (nums[swap] < nums[swap + 1]) {
                break;
            }
        }

        // Если сваппэбл элемент не нашелся - больше некуда лексикографически увеличивать =>
        // => массив отсортирован в обратном порядке - просто переворачиваем его
        if (swap < 0) {
            reverse(nums, 0);
            return;
        }

        // Увеличиваем лексикографический вес, меняя сваппэбл элемент с минимально возможным
        // Минимально возможным - это минимальный среди тех, которые больше сваппэбл элемента
        // А так как все элементы до сваппэбл элемента отсортированы в порядке убывания =>
        // => выбираем максимально правый из подходящих
        int swapWith = nums.length - 1;
        for (; swapWith > swap; swapWith--) {
            if (nums[swap] < nums[swapWith]) {
                break;
            }
        }

        // Меняем местами swap и swapWith
        int tmp = nums[swap];
        nums[swap] = nums[swapWith];
        nums[swapWith] = tmp;

        // Переворачиваем остаток массива
        reverse(nums, swap + 1);
    }

    private static void reverse(int[] nums, int start) {
        int tmp;
        for (int i = start; i < start + (nums.length - start + 1) / 2; i++) {
            tmp = nums[i];
            nums[i] = nums[start + nums.length - 1 - i];
            nums[start + nums.length - 1 - i] = tmp;
        }
    }
}
