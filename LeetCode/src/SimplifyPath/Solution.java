package SimplifyPath;

import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {
        String path = "/home/./dir1/dir2//dir3/../";
        System.out.println(simplifyPath(path)); // "/home/dir1/dir2"
    }
    public static String simplifyPath(String path) {
        StringBuilder simplePath = new StringBuilder();
        ArrayDeque<String> dirs = new ArrayDeque<>();
        String[] elements = path.split("/");
        for (var el: elements) {
            // Пропускаем двойные слэши, слэш рута и одинарные точки
            if (el != null && el.length() > 0 && !el.equals(".")) {
                // Если ".." - удаляем последнюю директорию из очереди
                // Если не "..", то добавляем директорию в список
                if (el.equals("..")) {
                    if (!dirs.isEmpty()) {
                        dirs.removeLast();
                    }
                } else {
                    dirs.addLast(el);
                }
            }
        }
        if (dirs.isEmpty()) {
            simplePath.append("/");
        }
        while (!dirs.isEmpty()) {
            simplePath.append("/").append(dirs.peekFirst());
            dirs.removeFirst();
        }
        return simplePath.toString();
    }
}
