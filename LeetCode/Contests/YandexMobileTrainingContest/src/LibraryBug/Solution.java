package LibraryBug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static String[] sortedStringsArray;
    private static int maxIndexFound;
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        sortedStringsArray = new String[10000];
        maxIndexFound = 0;

        String str;
        while (console.ready()) {
            str = console.readLine();
            insertString(str);
        }

        for (int i = 0; i <= maxIndexFound; i++) {
            System.out.println(sortedStringsArray[i]);
        }
    }

    private static void insertString(String str) {
        // Getting index from the string
        char[] chars = str.toCharArray();
        int indexStart = 0;
        while (indexStart < chars.length && !('0' <= chars[indexStart] && chars[indexStart] <= '9')) {
            indexStart++;
        }

        int indexEnd = indexStart;
        while (indexEnd < chars.length && ('0' <= chars[indexEnd] && chars[indexEnd] <= '9')) {
            indexEnd++;
        }

        // Inserting fixed string into array
        int index = Integer.parseInt(str.substring(indexStart, indexEnd)) - 1;
        String fixedString = str.substring(0, indexStart);
        if (indexEnd < str.length()) {
            fixedString += str.substring(indexEnd);
        }
        sortedStringsArray[index] = fixedString;
        maxIndexFound = Math.max(maxIndexFound, index);
    }
}
