package MaxConsecutiveOnesII;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 1, 0, 0, 1 };
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int oneCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            // Считаем количество единиц подряд
            while (i + oneCounter < nums.length && nums[i + oneCounter] == 1) {
                oneCounter++;
            }
            // Меняем посчитанные единицы на это число
            if (oneCounter > 1) {
                for (int j = i; j < i + oneCounter; j++) {
                    nums[j] = oneCounter;
                }
            }
            oneCounter = 0;
        }
        // Берем максимальное число из nums (максимальную длину последовательности единиц)
        int maxSum = Arrays.stream(nums).max().getAsInt();
        int newSum;
        for (int i = 0; i < nums.length - 2; i++) {
            // Проверяем все возможные разрывы длиной в один 0
            if (nums[i] > 0 && nums[i + 1] == 0 && nums[i + 2] > 0) {
                newSum = nums[i] + nums[i + 2] + 1;
                if (newSum > maxSum) {
                    maxSum = newSum;
                }
            }
        }
        return maxSum;
    }

    public static int findItFaster(int[] nums) {
        int leftCounter = 0;
        int rightCounter = 0;
        int maxSum = 0;
        int i = 0;
        // Пропускаем все нули в начале
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        // Считаем количество единиц (надеясь, что слева от одного 0)
        while (i + leftCounter < nums.length && nums[i + leftCounter] == 1) {
            leftCounter++;
        }
        i += leftCounter;
        while (i < nums.length) {
            // Если справа от единиц один 0, а потом снова единицы - считаем их количество
            if (nums[i] == 0 && i + 1 < nums.length && nums[i + 1] == 1) {
                i++;
                while (i + rightCounter < nums.length && nums[i + rightCounter] == 1) {
                    rightCounter++;
                }
                // Проверяем leftCounter + rightCounter + 1 > maxSum
                if (leftCounter + rightCounter + 1 > maxSum) {
                    maxSum = leftCounter + rightCounter + 1;
                }
                // Двигаем индекс, чтобы не проверять уже проверенное
                i += rightCounter;
                // Делаем leftCounter = rightCounter и дальше собираем только rightCounter'ы
                leftCounter = rightCounter;
                rightCounter = 0;
            } else {
                // Пропускаем нули
                while (i < nums.length && nums[i] == 0) {
                    i++;
                }
                leftCounter = 0;
                // Считаем количество единиц
                while (i + leftCounter < nums.length && nums[i + leftCounter] == 1) {
                    leftCounter++;
                }
                i += leftCounter;
            }
        }
        // Если справа от единиц нет ничего - проверяем, не больше ли это количество, чем максимально найденное
        if (leftCounter > maxSum) {
            maxSum = leftCounter;
        }
        return maxSum;
    }
}
