package SumOfScoresOfBuiltStrings;

public class Solution {
    public static void main(String[] args) {
        String s = "azbazbzaz";
        System.out.println(sumScores(s));
    }

    public static long sumScores(String s) {
        // Используем Z-функцию (https://e-maxx.ru/algo/z_function)
        int n = s.length();
        char[] sChars = s.toCharArray();
        int[] z = new int[n];
        int l = 0;
        int r = 0;

        for (int i = 1; i < n; i++) {
            // Если i входит в границу "изученности" строки - используем уже полученные значения Z-функции
            if (i <= r) {
                z[i] = Math.min(z[i - l], r - i + 1);
            }

            // До проверяем до конца (либо проверяем целиком, если не входит) тривиальным способом
            while (i + z[i] < n && sChars[z[i]] == sChars[i + z[i]]) {
                z[i]++;
            }

            // Обновляем границу "изученности" строки
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        long sum = n;
        for (int i = 0; i < n; i++) {
            sum += z[i];
        }

        return sum;
    }
}
