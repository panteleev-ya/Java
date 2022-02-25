package GenerateParentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> breaksArray = new ArrayList<>();
        generate(0, n, "", breaksArray);
        return breaksArray;
    }

    public static void generate(int sum, int openCount, String str, ArrayList<String> strings) {
        // Если количество открытых скобок равно 0
        if (sum == 0) {
            // Если можно открыть скобки - открываем
            if (openCount > 0) {
                generate(sum + 1, openCount - 1, str + "(", strings);
            }
            else {
                // Если нельзя и все закрыты - добавляем строку к результатам
                strings.add(str);
            }
        } else {
            // Если есть открытые скобки
            // Если можно открыть еще - либо открываем новую
            if (openCount > 0) {
                generate(sum + 1, openCount - 1, str + "(", strings);
            }
            // Либо закрываем открытую
            generate(sum - 1, openCount, str + ")", strings);
        }
    }
}
