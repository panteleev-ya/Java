package Day13;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            Node prev = null;
            for (int i = 0; i < levelCount; i++) {
                Node curNode = queue.poll();

                if (prev != null) {
                    prev.next = curNode;
                }

                prev = curNode;

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }

        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
