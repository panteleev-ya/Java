package InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.Random;

public class RandomizedSet {
    private static class ListNode {
        private final int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getNext() {
            return next;
        }
    }

    private final int capacity;
    private ListNode[] hashArray;
    private final Random random = new Random();
    private ArrayList<Integer> notNull = new ArrayList<>(9_500);

    public RandomizedSet(int capacity) {
        this.capacity = capacity;
        hashArray = new ListNode[capacity];
    }
    public RandomizedSet() {
        this.capacity = 20_000;
        hashArray = new ListNode[capacity];
    }

    private int getIndex(int val) {
        int index = val % capacity;
        if (index < 0) {
            index += capacity;
        }
        return index;
    }

    public boolean insert(int val) {
        int index = getIndex(val);
        if (hashArray[index] != null) {
            ListNode current = hashArray[index];
            if (current.getValue() == val) {
                return false; // same value
            }
            while (current.getNext() != null) {
                current = current.getNext();
                if (current.getValue() == val) {
                    return false; // same value
                }
            }
            ListNode newValue = new ListNode(val);
            current.setNext(newValue);
        } else {
            hashArray[index] = new ListNode(val);
        }
        notNull.add(index);
        return true;
    }

    public boolean remove(int val) {
        int index = getIndex(val);
        if (hashArray[index] == null) {
            return false; // nothing to remove
        }
        if (hashArray[index].getValue() == val) {
            hashArray[index] = hashArray[index].getNext(); // Next or null (if no Next)
            notNull.remove((Integer) index);
            return true;
        }
        ListNode current = hashArray[index];
        // Пока мы не нашли нужное val, и пока вообще есть где искать
        while(current.getNext() != null && current.getNext().getValue() != val) {
            current = current.getNext();
        }
        // Либо Next == null
        if (current.getNext() == null) {
            return false; // nothing to remove
        }
        // Либо у Next значение val
        // current -> current.next -> nextNext (might be null)
        // someVal    removableVal    someOtherVal
        ListNode nextNext = current.getNext().getNext();
        current.setNext(nextNext);
        // current -> nextNext (might be null)
        // someVal    someOtherVal
        notNull.remove((Integer) index);
        return true;
    }

    public int getRandom() {
        // Выбираем случайный существующий индекс (hashArray[index] != null)
        int index = notNull.get(random.nextInt(notNull.size()));
        if (hashArray[index].getNext() != null) {
            int depth = 2;
            ListNode current = hashArray[index].getNext();
            while (current.getNext() != null) {
                current = current.getNext();
                depth++;
            }
            int listNodeIndex = random.nextInt(depth);
            current = hashArray[index];
            for (int i = 0; i < listNodeIndex; i++) {
                current = current.getNext();
            }
            return current.getValue();
        }
        return hashArray[index].getValue();
    }
}
