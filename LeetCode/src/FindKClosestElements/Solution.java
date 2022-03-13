package FindKClosestElements;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,1,1,10,10,10};
        int k = 1;
        int x = 9;
        System.out.println(findClosestElements(arr, k, x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> result = new ArrayList<>();

        // Находим куда можно вставить Х и задаем ему соседей (left, right)
        int index = 0;
        int left, right;
        while (index < arr.length && x > arr[index]) {
            index++;
        }
        if (index == arr.length) {
            left = index - 1;
            right = index;
        } else if (x == arr[index]) {
            result.add(arr[index]);
            k--;
            left = index - 1;
            right = index + 1;
        } else {
            left = index - 1;
            right = index;
        }

        while (k > 0 && left >= 0 && right < arr.length) {
            // Если левый ближе правого - добавляем левый
            if (x - arr[left] <= arr[right] - x) {
                result.add(arr[left]);
                left--;
            } else { // Иначе добавляем правый
                result.add(arr[right]);
                right++;
            }
            k--;
        }

        // Добавляем остатки
        while (k > 0 && left >= 0) {
            result.add(arr[left]);
            left--;
            k--;
        }
        while (k > 0 && right < arr.length) {
            result.add(arr[right]);
            right++;
            k--;
        }

        result.sort(Comparator.comparingInt(i -> i));
        return result;
    }
}
