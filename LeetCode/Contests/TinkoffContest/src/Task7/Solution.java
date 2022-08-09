package Task7;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int q = Integer.parseInt(scanner.nextLine());

        // Indexes of all characters in chars
        List<List<Integer>> lettersIndexes = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            lettersIndexes.add(new ArrayList<>());
        }

        for (int i = 0; i < chars.length; i++) {
            lettersIndexes.get(chars[i] - 'a').add(i);
        }

        for (int i = 0; i < q; i++) {
            String[] requestData = scanner.nextLine().split(" ");
            int l = Integer.parseInt(requestData[0]);
            int r = Integer.parseInt(requestData[1]);

            int currentPosition = l - 1;
            int movesCount = 0;

            // BinarySearching for first and last indexes of all characters
            System.out.println("Range: [" + l + ", " + r + "]");
            for (int j = 0; j < 26; j++) {
                List<Integer> indexes = lettersIndexes.get(j);

                // If letter exists in word
                if (indexes.size() > 0) {
                    int lower = findFirstMoreThan(indexes, l - 1, r - 1, 0, indexes.size() - 1);
                    int higher = findLastLessThan(indexes, l - 1, r - 1, 0, indexes.size() - 1);
                    if (higher == -1 && lower != -1) {
                        higher = lower;
                    }
                    if (lower == -1 && higher != -1) {
                        lower = higher;
                    }

                    // If letter exists in sub-word
                    if (lower != -1) {
                        System.out.println((char) ('a' + j) + ": " + lower + ", " + higher);
                        if (currentPosition <= lower) {
                            movesCount += lower - currentPosition;
                        } else {
                            movesCount += r - l + 1;
                            movesCount -= currentPosition - lower;
                        }

                        movesCount += higher - lower;
                        currentPosition = higher;
                    }
                }
            }

            System.out.println(movesCount);
        }
    }

    private static int findFirstMoreThan(List<Integer> indexes, int min, int max, int l, int r) {
        int mid = (l + r) / 2;
        int value = indexes.get(mid);

        if (l == r) {
            return (min <= value && value <= max) ? indexes.get(l) : -1;
        }

        if (value < min) {
            return findFirstMoreThan(indexes, min, max, mid + 1, r);
        } else {
            return findFirstMoreThan(indexes, min, max, l, mid);
        }
    }

    private static int findLastLessThan(List<Integer> indexes, int min, int max, int l, int r) {
        int mid = (l + r) / 2;
        int value = indexes.get(mid);

        if (l == r) {
            return (min <= value && value <= max) ? indexes.get(l) : -1;
        }

        if (value > max) {
            return findLastLessThan(indexes, min, max, l, mid);
        } else {
            return findLastLessThan(indexes, min, max, mid + 1, r);
        }
    }
}

// tests
// #1
//hello
//3
//1 5
//1 2
//2 5

// #2
//hello
//2
//3 5
//4 5

// #3
//abccba
//100
//1 3
