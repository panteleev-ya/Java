package maximumNumberOfBooksYouCanTake;

public class Solution {
    public long maximumBooks(int[] books) {
        long maxAmount = 0L;
        for (int right = 0; right < books.length; right++) {
            int maxBooks = books[right];
            long booksAmount = books[right];
            for (int left = right - 1; left >= 0 && maxBooks > 0; left--) {
                maxBooks = Math.min(books[left], maxBooks - 1);
                booksAmount += maxBooks;
            }
            maxAmount = Math.max(maxAmount, booksAmount);
        }
        return maxAmount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumBooks(new int[]{8, 5, 2, 7, 9}));
    }
}
