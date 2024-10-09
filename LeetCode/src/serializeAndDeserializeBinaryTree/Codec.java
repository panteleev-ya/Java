package serializeAndDeserializeBinaryTree;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // serializing it by layers
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode l, TreeNode r) {
            val = x;
            left = l;
            right = r;
        }
    }
}
