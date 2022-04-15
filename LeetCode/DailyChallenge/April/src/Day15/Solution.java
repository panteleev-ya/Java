package Day15;

import java.awt.*;

public class Solution {
    public static void main(String[] args) {

    }
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        // Ищем новый корень, пока не найдем подходящий под условия
        // Возможно он уже подходит, тогда trim = root;
        TreeNode trim = findSuitableNode(root, low, high);

        // Если такого корня не нашлось
        if (trim == null) {
            return null;
        }

        // Запускаем рекурсивную функцию, которая удалит все лишнее из нашего нового дерева
        trimNewBST(trim, low, high);
        return trim;
    }
    public static void trimNewBST(TreeNode root, int low, int high) {
        // Ищем правые и левые подходящие ноды
        if (root.left != null) {
            root.left = findSuitableNode(root.left, low, high);
        }
        if (root.right != null) {
            root.right = findSuitableNode(root.right, low, high);
        }

        // Если они нашлись - ищем уже для каждой из них подходящие
        if (root.left != null) {
            trimBST(root.left, low, high);
        }
        if (root.right != null) {
            trimBST(root.right, low, high);
        }
    }
    public static TreeNode findSuitableNode(TreeNode node, int low, int high) {
        while (node.val < low || node.val > high) {
            // Если нода меньше - ищем справа
            while (node.val < low) {
                if (node.right == null) {
                    return null;
                }
                node = node.right;
            }

            // Если нода больше - ищем слева
            while (node.val > high) {
                if (node.left == null) {
                    return null;
                }
                node = node.left;
            }
        }
        return node;
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
