package Day19;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
        System.out.println(suggestedProducts(new String[]{"havana"}, "havana"));
        System.out.println(suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags"));
        System.out.println(suggestedProducts(new String[]{"havana"}, "tatiana"));
    }

    private static List<List<String>> result;

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        result = new ArrayList<>();
        Arrays.sort(products);
        int[] ra = {0, products.length};
        for (int i = 0; i < searchWord.length(); i++) {
            suggestion(products, searchWord, ra, i);
        }
        return result;
    }

    private static void suggestion(String[] products, String searchWord, int[] ra, int j) {
        List<String> current = new ArrayList<>();

        // We don't check prefixes again for the words (in products) with the same prefixes
        int newStart = -1, k = ra[0];
        for (; k < ra[1]; k++) {
            if (j < products[k].length() && products[k].charAt(j) == searchWord.charAt(j)) {
                if (newStart == -1) {
                    newStart = k;
                }
                if (current.size() < 3) {
                    current.add(products[k]);
                }
            } else {
                if (newStart != -1) {
                    break;
                }
            }
        }
        result.add(current);
        if (newStart == -1) {
            newStart = k;
        }
        ra[0] = newStart;
        ra[1] = k;
    }
}
