package ConvertSortedArrayToBinarySearchTree;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-10, 1, 2};
        System.out.println(sortedArrayToBST(nums));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        buildBST(root, nums, 0, nums.length - 1);
        return root;
    }

    private static void buildBST(TreeNode root, int[] nums, int start, int end) {
        int mid = end + start;
        mid = Math.max(mid, mid - mid / 2);
        root.val = nums[mid];

        if (end - start == 1) {
            root.left = new TreeNode(nums[start]);
            return;
        }
        if (end == start) {
            return;
        }
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        buildBST(root.left, nums, start, mid - 1);
        buildBST(root.right, nums, mid + 1, end);
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
