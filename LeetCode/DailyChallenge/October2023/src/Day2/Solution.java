package Day2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().winnerOfGame("AAABABB"));
    }

    public boolean winnerOfGame(String colors) {
        int aliceTurnsCount = 0;
        int bobTurnsCount = 0;
        int aliceColors = 0;
        int bobColors = 0;
        for (char color : colors.toCharArray()) {
            if (color == 'A') {
                bobColors = 0;
                aliceColors++;
                if (aliceColors >= 3) {
                    aliceTurnsCount++;
                }
            } else {
                aliceColors = 0;
                bobColors++;
                if (bobColors >= 3) {
                    bobTurnsCount++;
                }
            }
        }
        return aliceTurnsCount > bobTurnsCount;
    }
}
