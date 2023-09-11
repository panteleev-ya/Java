package Day15;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(
                                4,
                                new TreeNode(7),
                                null
                        ),
                        new TreeNode(5)
                ),
                new TreeNode(
                        3,
                        null,
                        new TreeNode(
                                6,
                                null,
                                new TreeNode(8)
                        )
                )
        );
        System.out.println(deepestLeavesSum(root));
    }

    public static int deepestLeavesSum(TreeNode root) {
        // Getting last level of Tree
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        nextLevel.add(root);
        while (!nextLevel.isEmpty()) { // while there is next level exists
            currentLevel = nextLevel;
            nextLevel = new LinkedList<>();
            for (TreeNode node: currentLevel) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
        }

        // Counting sum of values from the last level
        int lastLevelSum = 0;
        while (!currentLevel.isEmpty()) {
            lastLevelSum += currentLevel.poll().val;
        }
        return lastLevelSum;
    }

    private static class TreeNode {
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
