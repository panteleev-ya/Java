package deleteNodesAndReturnForest;

import java.util.*;

public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        TreeNode fakeStart = new TreeNode(to_delete[0], root, null);
        Set<Integer> forbidden = new HashSet<>();
        for (int val : to_delete) {
            forbidden.add(val);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(fakeStart);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            delHelper(node, forbidden, queue);
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }
        }
        return result;
    }

    private void delHelper(TreeNode node, Set<Integer> forbidden, Queue<TreeNode> queue) {
        if (node.left != null) {
            if (forbidden.contains(node.left.val)) {
                queue.add(node.left);
                node.left = null;
            } else {
                delHelper(node.left, forbidden, queue);
            }
        }
        if (node.right != null) {
            if (forbidden.contains(node.right.val)) {
                queue.add(node.right);
                node.right = null;
            } else {
                delHelper(node.right, forbidden, queue);
            }
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
