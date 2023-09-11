package Day17;

public class Solution {
    public static void main(String[] args) {

    }

    private enum CameraStatus {
        NOT_MONITORED,
        MONITORED_NO_CAM,
        MONITORED_WITH_CAM
    }

    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        CameraStatus top = dfs(root);
        return top == CameraStatus.NOT_MONITORED ? cameras + 1 : cameras;
    }

    private CameraStatus dfs(TreeNode current) {
        if (current == null) {
            return CameraStatus.MONITORED_NO_CAM;
        }
        CameraStatus leftChild = dfs(current.left);
        CameraStatus rightChild = dfs(current.right);

        if (leftChild == CameraStatus.MONITORED_NO_CAM && rightChild == CameraStatus.MONITORED_NO_CAM) {
            return CameraStatus.NOT_MONITORED;
        } else if (leftChild == CameraStatus.NOT_MONITORED || rightChild == CameraStatus.NOT_MONITORED) {
            cameras++;
            return CameraStatus.MONITORED_WITH_CAM;
        } else {
            return CameraStatus.MONITORED_NO_CAM;
        }
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
