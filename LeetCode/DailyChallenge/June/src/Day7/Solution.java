package Day7;

public class Solution {
    public static void main(String[] args) {

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[n + m];
        int i = 0, j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k] = nums1[i];
                i++;
            } else {
                mergedArray[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            mergedArray[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            mergedArray[k] = nums2[j];
            j++;
            k++;
        }
        for (i = 0; i < mergedArray.length; i++) {
            nums1[i] = mergedArray[i];
        }
    }
}
