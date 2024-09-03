package stepByStepDirectionsFromBinaryTreeNodeToAnother;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> pathToStart = findPath(root, startValue);
        List<Character> pathToDest = findPath(root, destValue);
        if (pathToStart == null || pathToDest == null) {
            return null;
        }
        pathToStart = new ArrayList<>(pathToStart);
        pathToDest = new ArrayList<>(pathToDest);
        int lengthOfCommonPrefix = findCommonPrefixLength(pathToStart, pathToDest);
        int upMovesCount = pathToStart.size() - lengthOfCommonPrefix;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < upMovesCount; i++) {
            sb.append('U');
        }
        for (int i = lengthOfCommonPrefix; i < pathToDest.size(); i++) {
            sb.append(pathToDest.get(i));
        }
        return sb.toString();
    }

    private LinkedList<Character> findPath(TreeNode node, int targetValue) {
        if (node == null) {
            return null;
        }
        if (node.val == targetValue) {
            return new LinkedList<>();
        }
        LinkedList<Character> left = findPath(node.left, targetValue);
        if (left != null) {
            left.addFirst('L');
            return left;
        }
        LinkedList<Character> right = findPath(node.right, targetValue);
        if (right != null) {
            right.addFirst('R');
            return right;
        }
        return null;
    }

    private int findCommonPrefixLength(List<Character> s, List<Character> t) {
        if (s == null || t == null) {
            return 0;
        }
        int i = 0;
        int maxPrefixLength = Math.min(s.size(), t.size());
        while (i < maxPrefixLength && s.get(i) == t.get(i)) {
            i++;
        }
        return i;
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
