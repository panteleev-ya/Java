package Day25;

import java.util.Iterator;

public class Solution {
    public static void main(String[] args) {
        PeekingIterator peekingIterator = new PeekingIterator(new Iterator<>() {
            final int[] array = new int[]{1, 2, 3};
            final int size = 3;
            int at = 0;
            @Override
            public boolean hasNext() {
                return at < size;
            }

            @Override
            public Integer next() {
                return array[at++];
            }
        }); // [1,2,3]
        System.out.println(peekingIterator.next());    // return 1, the pointer moves to the next element [1,2,3].
        System.out.println(peekingIterator.peek());    // return 2, the pointer does not move [1,2,3].
        System.out.println(peekingIterator.next());    // return 2, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.next());    // return 3, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.hasNext()); // return False
    }
}
