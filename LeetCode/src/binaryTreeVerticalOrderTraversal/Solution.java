package binaryTreeVerticalOrderTraversal;

import java.util.*;

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        // Pair of node and its column offset
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int column = 0;
        queue.offer(new Pair<>(root, column));

        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<>());
                }
                columnTable.get(column).add(root.val);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                queue.offer(new Pair<>(root.left, column - 1));
                queue.offer(new Pair<>(root.right, column + 1));
            }
        }

        for(int i = minColumn; i < maxColumn + 1; ++i) {
            output.add(columnTable.get(i));
        }

        return output;
    }

    private static class Pair<A, B> {
        A key;
        B value;

        public Pair(A key, B value) {
            this.key = key;
            this.value = value;
        }

        public A getKey() {
            return key;
        }

        public B getValue() {
            return value;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
