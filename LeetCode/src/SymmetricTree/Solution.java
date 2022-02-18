package SymmetricTree;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
    public boolean check(TreeNode left, TreeNode right) {
        // Если оба null - мы в конце и все ок
        // Если left == null, right != null -> не симметрично
        if (left == null) {
            return (right == null);
        }
        // Если left != null, right == null -> не симметрично
        if (right == null) {
            return false;
        }

        // Если оба не null
        if (left.val == right.val) {
            boolean leftSymmetric = check(left.left, right.right);  // ближе к краям
            boolean rightSymmetric = check(left.right, right.left);  // ближе к центру симметрии
            return leftSymmetric && rightSymmetric;  // true только если оба совпадают
        }
        return false;
    }
}
