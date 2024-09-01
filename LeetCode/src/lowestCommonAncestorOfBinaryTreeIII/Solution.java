package lowestCommonAncestorOfBinaryTreeIII;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> visited = new HashSet<>();
        while (!isAncestorOf(p, q, visited)) {
            p = p.parent;
        }
        return p;
    }

    private boolean isAncestorOf(Node ancestor, Node descendent, Set<Node> visited) {
        if (ancestor == null) {
            return false;
        }
        if (visited.contains(ancestor)) {
            return false;
        }
        visited.add(ancestor);
        if (ancestor == descendent) {
            return true;
        }
        return isAncestorOf(ancestor.left, descendent, visited)
                || isAncestorOf(ancestor.right, descendent, visited);
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    ;
}
