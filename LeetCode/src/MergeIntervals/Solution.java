package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 5}, {4, 7}, {9, 10}, {8, 11}, {12, 14}};
        merge(intervals);
    }
    public static int[][] merge(int[][] intervals) {
        // Если интервалов меньше 2 - нечего мерджить
        if (intervals.length < 2) {
            return intervals;
        }

        // Сортируем интервалы
        int[][] mergedIntervals = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(mergedIntervals, Comparator.comparingInt(pair -> pair[0]));

        // Мерджим интервалы
        int nullCounter = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            // [[1, 4], [3, 5]]
            // 4 >= 3 -> [null, [1, 5]]
            if (mergedIntervals[i][1] >= mergedIntervals[i + 1][0]) {
                mergedIntervals[i + 1][0] = mergedIntervals[i][0];
                mergedIntervals[i + 1][1] = Math.max(mergedIntervals[i + 1][1], mergedIntervals[i][1]);
                mergedIntervals[i] = null;
                nullCounter++;
            }
        }

        // Убираем все null и возвращаем
        int[][] result = new int[intervals.length - nullCounter][2];
        int index = 0;
        for (var pair: mergedIntervals) {
            if (pair != null) {
                result[index] = pair;
                index++;
            }
        }
        return result;
    }
}
