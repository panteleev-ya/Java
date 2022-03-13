package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxSubStrLength = 0;
        int index = 0;
        int currentLength = 0;
        HashMap<Character, Integer> distinctCharacters = new HashMap<>();

        while (index < s.length()) {
            Character character = s.charAt(index);

            // Если в мапе нет чара - закидываем его в мапу как ключ, а значением будет его индекс
            // Нужно для того, чтобы при повторе продолжить поиски подстроки с этого индекса + 1
            if (!distinctCharacters.containsKey(character)) {
                distinctCharacters.put(character, index);
                currentLength++;
                index++;
            }

            // Если в мапе есть чар - получаем повтор.
            // Меняем индекс на тот, после которого повторов не было
            // Мапу очищаем
            else {
                if (maxSubStrLength < currentLength) {
                    maxSubStrLength = currentLength;
                }
                currentLength = 0;
                index = distinctCharacters.get(character) + 1;
                distinctCharacters.clear();
            }
        }

        // Проверяем не оказалась ли последняя подстрока максимальной
        if (maxSubStrLength < currentLength) {
            maxSubStrLength = currentLength;
        }
        return maxSubStrLength;
    }
}
