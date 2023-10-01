package Day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] groupSizes = new int[]{2, 1, 3, 3, 3, 2};
        System.out.println(new Solution().groupThePeople(groupSizes));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> groups = new ArrayList<>();
        boolean[] isInGroup = new boolean[groupSizes.length];
        Arrays.fill(isInGroup, false);
        for (int i = 0; i < groupSizes.length; i++) {
            if (isInGroup[i]) {
                continue;
            }
            groups.add(buildGroup(groupSizes, isInGroup, i));
        }
        return groups;
    }

    public List<Integer> buildGroup(int[] groupSizes, boolean[] isInGroup, int index) {
        int targetGroupSize = groupSizes[index];
        int groupSize = 0;
        List<Integer> group = new ArrayList<>(targetGroupSize);
        for (int i = index; i < groupSizes.length && groupSize < targetGroupSize; i++) {
            if (groupSizes[i] != targetGroupSize) {
                continue;
            }
            groupSize++;
            group.add(i);
            isInGroup[i] = true;
        }
        return group;
    }
}
