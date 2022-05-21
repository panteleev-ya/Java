package ExcelSheetColumnTitle;

public class Solution {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(convertToTitle(i));
        }
    }

    public static String convertToTitle(int columnNumber) {
        // Convert base 10 number to Microsoft shit idea to count from 1 to 26
        StringBuilder columnTitleStringBuilder = new StringBuilder();
        while (columnNumber > 26) {
            if (columnNumber % 26 == 0) {
                columnTitleStringBuilder.append((char) ('A' - 1 + 26));
                columnNumber = (columnNumber / 26) - 1;
            } else {
                columnTitleStringBuilder.append((char) ('A' - 1 + (columnNumber % 26)));
                columnNumber = columnNumber / 26;
            }
        }
        columnTitleStringBuilder.append((char) (columnNumber + 'A' - 1));
        return columnTitleStringBuilder.reverse().toString();
    }
}
