package IsomorphicStrings;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String s, t;

//        s = "badc";
//        t = "baba";

//        s = "egg";
//        t = "add";

        s = "paper";
        t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphicByMaps(String s, String t) {
        HashMap<Character, Character> fromStoT = new HashMap<>();
        HashMap<Character, Character> fromTtoS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // S -> T or T -> S transitions are not valid
            if (fromStoT.getOrDefault(sChar, tChar) != tChar || fromTtoS.getOrDefault(tChar, sChar) != sChar) {
                return false;
            }

            // Add if not added yet
            if (!fromStoT.containsKey(sChar)) {
                fromStoT.put(sChar, tChar);
                fromTtoS.put(tChar, sChar);
            }
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        char[] fromStoT = new char[256];
        char[] fromTtoS = new char[256];

        for (int i = 0; i < sChars.length; i++) {
            char sChar = sChars[i];
            char tChar = tChars[i];

            // Not yet mapped
            if (fromStoT[sChar] == 0 && fromTtoS[tChar] == 0) {
                fromStoT[sChar] = tChar;
                fromTtoS[tChar] = sChar;
            } else if (fromStoT[sChar] != tChar || fromTtoS[tChar] != sChar) {
                return false;
            }
        }

        return true;
    }
}
