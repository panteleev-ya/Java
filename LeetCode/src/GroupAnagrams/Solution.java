package GroupAnagrams;

import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, ArrayList<String>> groups = new HashMap<>();
        for (var str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if (groups.containsKey(key)) {
                groups.get(key).add(str);
            } else {
                ArrayList<String> group = new ArrayList<>();
                group.add(str);
                groups.put(key, group);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (var key: groups.keySet()) {
            result.add(groups.get(key));
        }
        return result;
    }
}
