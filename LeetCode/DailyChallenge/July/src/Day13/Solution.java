package Day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelValues = new ArrayList<>();
        if (root == null) {
            return levelValues;
        }

        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        while (!levelNodes.isEmpty()) {
            Queue<TreeNode> nextLevelNodes = new LinkedList<>();
            List<Integer> currentLevelValues = new ArrayList<>();
            while (!levelNodes.isEmpty()) {
                TreeNode current = levelNodes.poll();

                // Add children to the next level
                if (current.left != null) {
                    nextLevelNodes.add(current.left);
                }
                if (current.right != null) {
                    nextLevelNodes.add(current.right);
                }

                currentLevelValues.add(current.val);
            }

            levelValues.add(currentLevelValues);
            levelNodes = nextLevelNodes;
        }

        return levelValues;
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
