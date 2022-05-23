package ExcelSheetColumnNumber;

public class Solution {
    public static void main(String[] args) {

    }
    public int titleToNumber(String columnTitle) {
        int number = 0;
        int multiplier = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            number += (columnTitle.charAt(i) - 'A' + 1) * multiplier;
            multiplier *= 26;
        }
        return number;
    }
}
