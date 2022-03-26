package LineReflection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int[][] arrayPoints = {{1, 1}, {-1, 1}, {-1, -3}, {1, -3}, {-2, -3}, {2, -3}, {0, -3}};
        int[][] arrayPoints = {{0, 0}, {1, 0}};
        System.out.println(isReflected(arrayPoints));
    }

    public static boolean isReflected(int[][] points) {
        // Собираем хэшмапу вида Map<Y, List of X>
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int[] point: points) {
            int x = point[0];
            int y = point[1];
            if (!hashMap.containsKey(y)) {
                hashMap.put(y, new ArrayList<>());
            }
            hashMap.get(y).add(x);
        }

        Double median = null;
        for (int y: hashMap.keySet()) {
            // Сортируем списки Х-ов
            ArrayList<Integer> currentX = hashMap.get(y);
            currentX.sort(Comparator.comparingInt(i -> i));

            // Проверяем что все значения X имеют симметричного соседа
            for (int i = 0; i < currentX.size() / 2 + 1; i++) {
                int right = currentX.get(currentX.size() - 1 - i);
                int left = currentX.get(i);
                double newMedian;
                if (left == right) {
                    newMedian = left;
                } else {
                    newMedian = left + (right - left) / 2.0;
                }
                if (median == null) {
                    median = newMedian;
                } else {
                    if (median != newMedian) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
