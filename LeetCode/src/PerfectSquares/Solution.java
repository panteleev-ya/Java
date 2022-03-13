package PerfectSquares;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 6175;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        if (n <= 1) {
            return n;
        }

        // Запускаем алгоритм "задачи сдачи"

        // Формируем массив "расстояний" до каждого числа от 0 до N включительно
        // Расстояние до I - это минимальное количество полных квадратов, сумма которых дает I
        // Также добавляем массив флагов (находили ли мы этот способ или нет)
        int[] dp = new int[n + 1];
        boolean[] map = new boolean[n + 1];

        // Заполняем его стартовыми значениями
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=1;

        for (int i = 2; i <= n; i++){

            // Если N - полный квадрат
            if (map[n]) {
                return 1;
            }

            int sq = i * i;
            if (sq <= n) {
                map[sq] = true;
            }

            // Если I - полный квадрат
            if (map[i]) {
                dp[i] = 1;
            } else {
                // Иначе выбираем: получили мы самый короткий "путь" или есть короче
                for (int j = i - 1; j > 0 && j >= i - j; j--){
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }
        return dp[n];

        // Медленно, но работает

//        ArrayList<Integer> squares = new ArrayList<>();
//        for (int i = 0; i < 100 && (i + 1) * (i + 1) <= n; i++) {
//            squares.add((i + 1) * (i + 1));
//        }
//        IntegerPointer max = new IntegerPointer(n);
//        subNumber(n, 0 ,squares, max, squares.size() - 1);
//        return max.getValue();
    }

    public static class IntegerPointer {
        private int value;

        public IntegerPointer(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private static void subNumber(int sum, int depth, ArrayList<Integer> numbers, IntegerPointer min) {
        if (sum == 0) {
            if (min.getValue() > depth) {
                min.setValue(depth);
            }
            return;
        }
        if (depth > min.getValue()) {
            return;
        }
        int maxInd = binarySearch(numbers, 0, numbers.size() - 1, sum);
        for (int i = maxInd; i >= 0; i--) {
            subNumber(sum - numbers.get(i), depth + 1, numbers, min);
        }
    }

    private static int binarySearch(ArrayList<Integer> nums, int start, int end, int target) {
        int mid = start + (end - start) / 2;

        // Некуда искать
        if (mid == start) {
            if (nums.get(end) > target) {
                return start;
            }
            return end;
        }

        // Не влезает
        if (nums.get(mid) > target) {
            return binarySearch(nums, start, mid, target);
        } else if (nums.get(mid) <= target && nums.get(mid + 1) > target) {
            // Нашли
            return mid;
        // Влезает, но можно больше
        } else {
            return binarySearch(nums, mid, end, target);
        }
    }
}
