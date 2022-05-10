package Day10;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(combinations, new ArrayList<>(), k, n, 1);
        return combinations;
    }

    private static void backtracking(List<List<Integer>> combinations, List<Integer> combination, int k, int n, int start) {
        if (combination.size() == k && n == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= 9; i++) {
            combination.add(i);
            backtracking(combinations, combination, k, n - i, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
