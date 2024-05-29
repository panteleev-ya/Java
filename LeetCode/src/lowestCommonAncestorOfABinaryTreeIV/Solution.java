package lowestCommonAncestorOfABinaryTreeIV;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6, null, null), new TreeNode(2, new TreeNode(7, null, null), new TreeNode(4, null, null))), new TreeNode(1, new TreeNode(0, null, null), new TreeNode(8, null, null)));
        TreeNode[] nodes = {new TreeNode(4, null, null), new TreeNode(7, null, null)};
        System.out.println(new Solution().lowestCommonAncestor(root, nodes));
    }

    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> targetNodes = new HashSet<>();
        for (TreeNode node : nodes) {
            targetNodes.add(node.val);
        }
        helper(root, targetNodes);
        return lca;
    }

    int helper(TreeNode root, Set<Integer> nodes) {
        if (root == null) {
            return 0;
        }
        int leftCount = helper(root.left, nodes);
        int rightCount = helper(root.right, nodes);
        int foundCount = leftCount + rightCount;
        if (nodes.contains(root.val)) {
            foundCount++;
        }
        if (foundCount == nodes.size() && lca == null) {
            lca = root;
        }
        return foundCount;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }
}

