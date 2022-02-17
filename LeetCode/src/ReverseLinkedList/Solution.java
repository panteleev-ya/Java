package ReverseLinkedList;

public class Solution {
    public static void main(String[] args) {

    }
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // Был список 1 -> 2 -> 3 -> 4 -> 5, а надо получить 5 -> 4 -> 3 -> 2 -> 1
        // Собираем список с конца, начнем с 1
        ListNode reversed = new ListNode(head.val);
        while (head.next != null) {
            // Берем следующий элемент списка
            head = head.next;
            // newNode будет 2
            ListNode newNode = new ListNode(head.val);
            // Теперь newNode это 2 -> 1
            newNode.next = reversed;
            // А теперь сам reversed уже 2 -> 1
            reversed = newNode;

            // На следующей итерации будет newNode = 3; reversed = 3 -> 2 -> 1,
            // а на еще одной уже          newNode = 4; reversed = 4 -> 3 -> 2 -> 1
            // и так пока наш развернутый список не соберется целиком
        }
        return reversed;
    }
}
