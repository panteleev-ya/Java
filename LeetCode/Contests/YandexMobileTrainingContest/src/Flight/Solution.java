package Flight;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] startTime = console.nextLine().split(":");
        String[] endTime = console.nextLine().split(":");

        int dayHours = 24;
        int hourMinutes = 60;
        int difference = Integer.parseInt(console.nextLine());
        int start = Integer.parseInt(startTime[0]) * hourMinutes + Integer.parseInt(startTime[1]);
        int end = Integer.parseInt(endTime[0]) * hourMinutes + Integer.parseInt(endTime[1]) - difference * hourMinutes;

        int day = dayHours * hourMinutes;
        if (end > day) {
            end -= day;
        } else if (end < 0) {
            end += day;
        }
        int flight = end - start;
        if (flight > day) {
            flight -= day;
        } else if (flight < 0) {
            flight += day;
        }
        String flightMinutes = String.valueOf(flight % hourMinutes);
        if (flightMinutes.length() == 1) {
            flightMinutes = "0" + flightMinutes;
        }
        String flightHours = String.valueOf(flight / hourMinutes);
        System.out.println(flightHours + ":" + flightMinutes);
    }
}
//23:00
//03:00
//-2