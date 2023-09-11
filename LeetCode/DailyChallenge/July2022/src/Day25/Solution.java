package Day25;

public class Solution {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{0, nums.length - 1};

        // Проверяем, что число вообще может быть в диапазоне, и что nums.length >= 2
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            }
            return new int[]{-1, -1};
        }

        // Ищем начало
        if (nums[0] != target) {
            if (nums[1] <= target) {
                range[0] = binarySearchTargetLeft(nums, 1, nums.length - 1, target);
            } else {
                return new int[]{-1, -1};
            }
        }

        // Ищем конец
        if (nums[nums.length - 1] != target) {
            if (nums[nums.length - 2] >= target) {
                range[1] = binarySearchTargetRight(nums, 0, nums.length - 2, target);
            } else {
                return new int[]{-1, -1};
            }
        }

        // Возвращаем полученный диапазон
        return range;
    }

    // Ищем индекс mid такой, что: nums[mid-1] < target && nums[mid] == target
    private int binarySearchTargetLeft(int[] nums, int start, int end, int target) {
        // Нашли крайний левый target
        if (nums[start] == target && nums[start - 1] < target) {
            return start;
        }
        int mid = start + (end - start + 1) / 2;

        // Некуда искать
        if (mid == end) {
            // Нашли крайний левый target
            if (nums[mid] == target && nums[mid - 1] < target) {
                return mid;
            }
            return -1;
        }

        // Больше или меньше чем нужно
        if (nums[mid] >= target) {
            return binarySearchTargetLeft(nums, start, mid, target);
        } else {
            return binarySearchTargetLeft(nums, mid, end, target);
        }
    }

    // Ищем индекс mid такой, что: nums[mid+1] > target && nums[mid] == target
    private int binarySearchTargetRight(int[] nums, int start, int end, int target) {
        // Нашли крайний правый target
        if (nums[end] == target && nums[end + 1] > target) {
            return end;
        }
        int mid = start + (end - start) / 2;

        // Некуда искать
        if (mid == start) {
            // Нашли крайний правый target
            if (nums[mid] == target && nums[mid + 1] > target) {
                return mid;
            }
            return -1;
        }

        // Больше или меньше чем нужно
        if (nums[mid] > target) {
            return binarySearchTargetRight(nums, start, mid, target);
        } else {
            return binarySearchTargetRight(nums, mid, end, target);
        }
    }
}
