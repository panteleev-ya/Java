package Day4;

public class Solution {
    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        int candies = ratings.length;
        int i = 1;
        while (i < ratings.length) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int increase = 0;
            while (ratings[i] > ratings[i - 1]) {
                increase++;
                candies += increase;
                i++;
                if (i == ratings.length) {
                    return candies;
                }
            }

            int decrease = 0;
            while (i < ratings.length && ratings[i] < ratings[i - 1]) {
                decrease++;
                candies += decrease;
                i++;
            }

            candies -= Math.min(increase, decrease);
        }
        return candies;
    }
}
