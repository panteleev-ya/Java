package deleteNodeFromBST;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left != null) {
                // the node has a left child
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            } else if (root.right != null) {
                // the node has a right child
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                // the node is a leaf
                return null;
            }
        }

        return root;
    }

    // next val in sorted order
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    // prev val in sorted order
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
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
