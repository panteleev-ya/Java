package PalindromeLinkedList;

import java.util.ArrayDeque;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        ListNode ln5 = new ListNode(1);
        ListNode ln4 = new ListNode(2, ln5);
        ListNode ln3 = new ListNode(2, ln4);
        ListNode ln2 = new ListNode(2, ln3);
        ListNode ln1 = new ListNode(1, ln2);
        System.out.println(isPalindrome(ln1));
    }

    public static boolean isPalindrome(ListNode head) {
        // Если пустой или из 1 элемента
        if (head == null || head.next == null) {
            return true;
        }

        // Проверяем что список можно читать с обеих сторон одинаково
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Stack <Integer> stack = new Stack<>();
        while (head != null) {
            deque.add(head.val);
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty() && !deque.isEmpty()) {
            if (stack.peek().equals(deque.peek())) {
                stack.pop();
                deque.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty() && deque.isEmpty();
    }
}

