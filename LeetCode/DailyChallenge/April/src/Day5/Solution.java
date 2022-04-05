package Day5;

public class Solution {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        // Указатели на левый и правый столбцы (ограничители контейнера)
        int left = 0;
        int right = height.length - 1;

        // Счетчик максимальной площади
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            // Смещаем к центру указатель на тот столбец, который меньше
            // Потому что, меняя больший (из двух) столбец на какой-то еще:
            // 1) Math.min(height[left], height[right]) либо уменьшится, либо не изменится
            // 2) (right - left) уменьшится
            // Поэтому нет никакого смысла двигать больший столбец - двигаем всегда меньший из двух
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

            // Проверяем изменение максимальной площади
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
        }

        return max;
    }
}
