package Airplane;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static boolean[][] isSeatEmpty;
    private static char[][] seats;
    private static final char[] seatsLetters = "ABC_DEF".toCharArray();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        // Reading init airplane seats state
        isSeatEmpty = new boolean[n][7];
        seats = new char[n][7];
        for (int i = 0; i < n; i++) {
            char[] ABC_DEF = console.nextLine().toCharArray();
            for (int j = 0; j < 7; j++) {
                seats[i][j] = ABC_DEF[j];
                if (seats[i][j] == '.') {
                    isSeatEmpty[i][j] = true;
                }
            }
        }

        // Reading passengers groups
        int m = Integer.parseInt(console.nextLine());
        for (int request = 0; request < m; request++) {
            String[] requestArguments = console.nextLine().split(" ");
            int passengersCount = Integer.parseInt(requestArguments[0]);
            boolean wantLeftSide = requestArguments[1].equals("left");
            boolean wantsWindow = requestArguments[2].equals("window");

            boolean passengersResolved = false;
            for (int row = 0; row < n; row++) {
                List<Integer> usedSeats = checkRow(row, passengersCount, wantLeftSide, wantsWindow);
                if (usedSeats != null) {
                    printSuccessfulMessage(row, usedSeats);
                    printUsedSeats(row, usedSeats);
                    passengersResolved = true;
                    break;
                }
            }
            if (!passengersResolved) {
                System.out.println("Cannot fulfill passengers requirements");
            }
        }
    }

    private static void printSuccessfulMessage(int row, List<Integer> usedSeats) {
        System.out.print("Passengers can take seats:");
        for (int usedSeatIndex : usedSeats) {
            System.out.print(" " + (row + 1) + seatsLetters[usedSeatIndex]);
        }
        System.out.println();
    }

    private static void printUsedSeats(int row, List<Integer> usedSeats) {
        for (int index : usedSeats) {
            seats[row][index] = 'X';
        }
        for (char[] seatsRow : seats) {
            for (char seat : seatsRow) {
                System.out.print(seat);
            }
            System.out.println();
        }
        for (int index : usedSeats) {
            seats[row][index] = '#';
        }
    }

    private static List<Integer> checkRow(int row, int passengersCount, boolean wantLeftSide, boolean wantsWindow) {
        List<Integer> usedSeats = new ArrayList<>();
        int start = 0;
        int end = 2;
        int windowIndex = start;
        int aliseIndex = end;
        if (!wantLeftSide) {
            start = 4;
            end = 6;
            windowIndex = end;
            aliseIndex = start;
        }

        // Resolving special index
        int specialIndex = aliseIndex;
        int lastIndex = windowIndex;
        if (wantsWindow) {
            specialIndex = windowIndex;
            lastIndex = aliseIndex;
        }

        // Check if special seat is busy
        if (!isSeatEmpty[row][specialIndex]) {
            return null;
        } else {
            usedSeats.add(specialIndex);
        }
        passengersCount--;

        // Check if center seat need to be used, but it is busy already
        if (passengersCount > 0) {
            if (!isSeatEmpty[row][end - 1]) {
                return null;
            } else {
                usedSeats.add(end - 1);
            }
            passengersCount--;
        }

        // Check if there were 3 passengers
        if (passengersCount > 0) {
            if (!isSeatEmpty[row][lastIndex]) {
                return null;
            } else {
                usedSeats.add(lastIndex);
            }
        }

        usedSeats.sort(Comparator.comparingInt(i -> i));
        for (int usedSeat: usedSeats) {
            isSeatEmpty[row][usedSeat] = false;
        }
        return usedSeats;
    }
}
