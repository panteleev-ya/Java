package AddTwoNumbers;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);
    }

    static class IntPointer {
        private int value;
        public IntPointer(int value) {
            this.value = value;
        }
        public int get() {
            return value;
        }
        public void set(int value) {
            this.value = value;
        }
    }

    private static int getOverload(int newDigit) {
        if (newDigit >= 10) {
            return 1;
        }
        return 0;
    }

    private static ListNode addDigits(ListNode currentDigit, ListNode source, IntPointer overloadPointer) {
        int newDigit;
        int overload = overloadPointer.get();
        while (source != null) {
            newDigit = source.val + overload;
            overload = getOverload(newDigit);
            newDigit -= 10 * overload; // -10 если newDigit больше 10, иначе -0

            currentDigit.val = newDigit;
            source = source.next;
            if (source != null) {
                currentDigit.next = new ListNode();
                currentDigit = currentDigit.next;
            }
        }
        overloadPointer.set(overload);
        return currentDigit;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Если хоть один пустой
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode sum = new ListNode();
        ListNode currentDigit = sum;
        int newDigit;
        int overload = 0;

        // Пока оба разряда существуют
        while (l1 != null && l2 != null) {

            // Создаем новый разряд, учитываем "перегрузку" и получаем новую "перегрузку", если она есть
            newDigit = l1.val + l2.val + overload;
            overload = getOverload(newDigit);
            newDigit -= 10 * overload; // -10 если newDigit больше 10, иначе -0

            // Записываем это значение
            currentDigit.val = newDigit;

            l1 = l1.next;
            l2 = l2.next;

            // Если оба числа закончились
            if (l1 == null && l2 == null) {
                break;
            }

            currentDigit.next = new ListNode();
            currentDigit = currentDigit.next;
        }

        IntPointer overloadPointer = new IntPointer(overload);
        currentDigit = addDigits(currentDigit, l1, overloadPointer);
        currentDigit = addDigits(currentDigit, l2, overloadPointer);

        overload = overloadPointer.get();
        if (overload > 0) {
            currentDigit.next = new ListNode(overload);
        }
        return sum;
    }
}
