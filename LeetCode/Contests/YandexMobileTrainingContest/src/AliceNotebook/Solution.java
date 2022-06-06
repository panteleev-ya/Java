package AliceNotebook;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {
    private static void ask(String date) {
        System.out.printf("? %s\n", date);
        System.out.flush();
    }

    private static void print(String answer) {
        System.out.printf("! %s\n", answer);
        System.out.flush();
    }

    public static void main(String[] args) {
        // read game configuration
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // Getting begin and end dates for binary search
        Calendar dateBegin = new GregorianCalendar(1970, Calendar.JANUARY, 1);
        Calendar dateEnd = new GregorianCalendar(2020, Calendar.DECEMBER, 31);
        long begin = dateBegin.getTimeInMillis();
        long end = dateEnd.getTimeInMillis();
        String stringDateBegin = dateToString(dateBegin);
        String stringDateEnd = dateToString(dateEnd);

        ask(stringDateEnd);
        int k = getK(scanner);
        int targetK = (k + 1) / 2;
        int currentK = 0;

        long mid;
        Calendar dateMiddle = new GregorianCalendar();
        // Binary searching answer
        while (begin < end && targetK != currentK) {
            Calendar b = new GregorianCalendar();
            b.setTimeInMillis(begin);
            Calendar e = new GregorianCalendar();
            e.setTimeInMillis(end);

            // Getting current date
            mid = (end - begin) / 2 + begin;
            dateMiddle = new GregorianCalendar();
            dateMiddle.setTimeInMillis(mid);
            String stringDate = dateToString(dateMiddle);

            ask(stringDate);
            currentK = getK(scanner);

            if (currentK < targetK) {
                begin = mid + 1;
            } else if (currentK > targetK) {
                end = mid;
            }
        }

        print(dateToString(dateMiddle));
    }

    private static String dateToString(Calendar date) {
        String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
        String month = String.valueOf((date.get(Calendar.MONTH) + 1));
        String year = String.valueOf(date.get(Calendar.YEAR));

        StringBuilder result = new StringBuilder();
        if (day.length() == 1) {
            result.append("0");
        }
        result.append(day).append(".");
        if (month.length() == 1) {
            result.append("0");
        }
        result.append(month).append(".").append(year);

        return result.toString();
    }

    private static int getK(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine().substring(2));
    }
}
