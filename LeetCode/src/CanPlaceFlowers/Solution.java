package CanPlaceFlowers;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(new int[]{0}, 1));
        System.out.println(new Solution().canPlaceFlowers(new int[]{0, 0, 1}, 1));
        System.out.println(new Solution().canPlaceFlowers(new int[]{1, 0, 0}, 1));
        System.out.println(new Solution().canPlaceFlowers(new int[]{0, 1}, 1));
        System.out.println(new Solution().canPlaceFlowers(new int[]{1, 0}, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }
            if (i >= 1 && flowerbed[i - 1] == 1) {
                continue;
            }
            if (i <= flowerbed.length - 2 && flowerbed[i + 1] == 1) {
                continue;
            }
            flowerbed[i] = 1;
            count++;
        }
        return count >= n;
    }
}