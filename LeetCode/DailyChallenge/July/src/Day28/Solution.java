package Day28;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        int[] counter = new int[128];
        for (char c : s.toCharArray()) {
            counter[c]++;
        }
        for (char c : t.toCharArray()) {
            counter[c]--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
