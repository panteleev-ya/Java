package Day13;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            triangle.add(new ArrayList<>());
        }
        triangle.get(0).add(2);
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);

//        triangle.add(new ArrayList<>());
//        triangle.get(0).add(-10);

        System.out.println(minimumTotal(triangle));
    }

    private static Integer[][] memo;

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new Integer[n][n];
        return dfs(0, 0, triangle);
    }

    private static int dfs(int level, int position, List<List<Integer>> triangle) {
        if (memo[level][position] != null) {
            return memo[level][position];
        }

        int path = triangle.get(level).get(position);
        if (level < triangle.size() - 1) {
            path += Math.min(dfs(level + 1, position, triangle), dfs(level + 1, position + 1, triangle));
        }

        return memo[level][position] = path;
    }
}
