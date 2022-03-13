package SerializeAndDeserializeBST;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String delimiter = ",";
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        ArrayList<String> nodes = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        TreeNode nullNode = new TreeNode(-1); // будет использован как null node

        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode current = q.peekFirst();
            q.removeFirst();

            if (current == nullNode) {
                nodes.add("n");
            } else {
                nodes.add(String.valueOf(current.val));
                if (current.left != null) {
                    q.addLast(current.left);
                } else {
                    q.addLast(nullNode);
                }
                if (current.right != null) {
                    q.addLast(current.right);
                } else {
                    q.addLast(nullNode);
                }
            }
        }

        StringBuilder nullBuilder = new StringBuilder();
        result.append(nodes.get(0));
        for (int i = 1; i < nodes.size(); i++) {
            String nextNode = nodes.get(i);
            if (nextNode.equals("n")) {
                nullBuilder.append(nextNode);
                nullBuilder.append(delimiter);
            } else {
                if (!nullBuilder.isEmpty()) {
                    result.append(delimiter);
                    result.append(nullBuilder);
                    result.append(nextNode);

                    nullBuilder = new StringBuilder();

                } else {
                    result.append(delimiter);
                    result.append(nextNode);
                }
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String delimiter = ",";
        if (data.equals("")) {
            return null;
        }

        // Получаем все ноды по отдельности, пихаем в очередь
        // Создаем очередь из "not null nodes"
        String[] splitData = data.split(delimiter);
        ArrayDeque<String> nodes = new ArrayDeque<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        for (String node : splitData) {
            nodes.addLast(node);
        }

        // IDEA ругается
        if (nodes.isEmpty()) {
            return null;
        }

        // Добавляем в дерево root
        TreeNode deSer = new TreeNode(Integer.parseInt(nodes.peek()));
        nodes.removeFirst();
        q.addLast(deSer);

        // Если есть только root
        if (nodes.isEmpty()) {
            return deSer;
        }

        // Пока есть "not null nodes" - проверяем, нет ли у них детей
        String nextStr;
        while (!q.isEmpty() && !nodes.isEmpty()) {
            TreeNode current = q.peek();
            q.pop();

            nextStr = nodes.peekFirst();
            if (nextStr != null) {
                if (!nextStr.equals("n")) {
                    current.left = new TreeNode(Integer.parseInt(nextStr));
                    q.addLast(current.left);
                }
                nodes.removeFirst();
            }

            nextStr = nodes.peekFirst();
            if (nextStr != null) {
                if (!nextStr.equals("n")) {
                    current.right = new TreeNode(Integer.parseInt(nextStr));
                    q.addLast(current.right);
                }
                nodes.removeFirst();
            }

        }
        return deSer;
    }
}
