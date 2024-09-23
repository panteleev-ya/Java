package medianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller;
        int[] bigger;
        if (nums1.length < nums2.length) {
            smaller = nums1;
            bigger = nums2;
        } else {
            smaller = nums2;
            bigger = nums1;
        }

        int totalLength = smaller.length + bigger.length;
        int half = (totalLength + 1) / 2;

        int left = 0;
        int right = smaller.length;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            int smallerEnd = i > 0 ? smaller[i - 1] : Integer.MIN_VALUE;
            int smallerNext = i < smaller.length ? smaller[i] : Integer.MAX_VALUE;
            int biggerEnd = j > 0 ? bigger[j - 1] : Integer.MIN_VALUE;
            int biggerNext = j < bigger.length ? bigger[j] : Integer.MAX_VALUE;

            if (smallerEnd <= biggerNext && biggerEnd <= smallerNext) {
                if (totalLength % 2 != 0) {
                    return Math.max(smallerEnd, biggerEnd);
                }
                return (Math.max(smallerEnd, biggerEnd) + Math.min(smallerNext, biggerNext)) / 2.0;
            } else if (smallerEnd > biggerNext) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return -1;
    }
}
