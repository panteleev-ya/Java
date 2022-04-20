package Day20;

class BSTIterator {
    private TreeNode sortedTree;
    public BSTIterator(TreeNode root) {
        // Building sorted tree
        sortValues(root);
    }

    public int next() {
        int value = sortedTree.val;
        sortedTree = sortedTree.right;
        return value;
    }

    public boolean hasNext() {
        return sortedTree != null;
    }
    private void sortValues(TreeNode root) {
        if (root.right != null) {
            sortValues(root.right);
        }
        this.sortedTree = new TreeNode(root.val, null, this.sortedTree);
        if (root.left != null) {
            sortValues(root.left);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
