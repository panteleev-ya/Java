package Day14;

public class Solution {
    public static void main(String[] args) {

    }

    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        // if there are no left and right children
        if (end < start) return null;

        TreeNode tree = new TreeNode(preorder[index++]);
        //if(start == end) return tree;

        int rootIndex = findIndex(inorder, start, end, tree.val);

        tree.left = buildTree(preorder, inorder, start, rootIndex - 1);
        tree.right = buildTree(preorder, inorder, rootIndex + 1, end);
        return tree;
    }

    private int findIndex(int[] inorder, int start, int end, int val) {
        while (start < end && inorder[start] != val && inorder[end] != val) {
            start++;
            end--;
        }
        return inorder[start] == val ? start : end;
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
