package Day29;

public class Solution {
    public static void main(String[] args) {

    }

    public int maxProduct(String[] words) {
        int[] hashes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int hash = 0;
            for (char ch: words[i].toCharArray()) {
                int addChar = 1 << (ch - 'a');
                if ((addChar & hash) != 0) {
                    continue;
                }
                hash += addChar;
            }
            hashes[i] = hash;
        }

        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((hashes[i] & hashes[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }
}
