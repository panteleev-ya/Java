package SearchInRotatedSortedArray;

public class Solution {
    public static void main(String[] args) {
        // Odd
        int[] nums0 = {0, 1, 2, 3, 4, 5, 6};
        int[] nums1 = {7, 0, 1, 2, 4, 5, 6};
        int[] nums2 = {6, 7, 0, 1, 2, 4, 5};
        int[] nums3 = {5, 6, 7, 0, 1, 2, 4};
        int[] nums4 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums5 = {2, 4, 5, 6, 7, 0, 1};
        int[] nums6 = {1, 2, 4, 5, 6, 7, 0};

        // Even
//        int[] nums0 = {0, 1, 2, 3, 4, 5, 6, 7};
//        int[] nums1 = {7, 8, 0, 1, 2, 4, 5, 6};
//        int[] nums2 = {6, 7, 8, 0, 1, 2, 4, 5};
//        int[] nums3 = {5, 6, 7, 8, 0, 1, 2, 4};
//        int[] nums4 = {4, 5, 6, 7, 8, 0, 1, 2};
//        int[] nums5 = {3, 4, 5, 6, 7, 8, 0, 1};
//        int[] nums6 = {2, 3, 4, 5, 6, 7, 8, 0};

        // Tests
        System.out.println(search(nums0, 2));
        System.out.println(search(nums1, 2));
        System.out.println(search(nums2, 2));
        System.out.println(search(nums3, 2));
        System.out.println(search(nums4, 2));
        System.out.println(search(nums5, 2));
        System.out.println(search(nums6, 2));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (target == nums[0]) {
                return 0;
            }
            return -1;
        }
        int minIndex = binarySearchMin(nums, 0, nums.length - 1);
        int maxIndex = (minIndex - 1 + nums.length) % nums.length; // UPD: сдвиг может быть равен 0, условие некорректно (либо тесты)

        return binarySearchTarget(nums, minIndex, maxIndex, target);
    }

    private static int binarySearchMin(int[] nums, int start, int end) {
        // Если в диапазоне только два числа - возвращаем минимум
        if (end - start + 1 == 2) {
            if (nums[start] > nums[end]) {
                return end;
            } else {
                // UPD: сдвиг может быть равен 0, условие некорректно (либо тесты)
                return start;
            }
        }

        // Находим границы левого и правого диапазонов
        int mid = start + (end - start) / 2;
        int left;
        int right = mid;
        if ((end - start + 1) % 2 == 0) {
            left = mid - 1;
        } else {
            left = mid;
        }

        // Выбираем тот, в котором слева число больше, чем справа
        if (nums[start] > nums[left]) {
            return binarySearchMin(nums, start, left);
        } else if (nums[right] > nums[end]) {
            return binarySearchMin(nums, right, end);
        } else {
            // Такое может быть только если длина четная и левый диапазон - [4, 5, 6, 7], а правый - [0, 1, 2, 3]
            // UPD: Условие некорректное (либо тест), при сдвиге 0 такое может быть и при "левый диапазон - [0, 1, 2, 3], а правый - [4, 5, 6, 7]"
            if (nums[start] < nums[mid]) {
                return start;
            }
            return mid;
        }
    }

    private static int binarySearchTarget(int[] nums, int start, int end, int target) {
        // Вдруг нам и искать не надо
        if (target == nums[start]) {
            return start; // равен левому краю
        } else if (target == nums[end]) {
            return end; // равен правому краю
        } else if (target < nums[start] || target > nums[end]) {
            return -1; // вообще не может входить в диапазон
        } else {
            int mid;
            if (start > end) {
                mid = (start + (end + nums.length - start + 1) / 2) % nums.length;
            } else {
                mid = (start + (end - start + 1) / 2);
            }

            // Негде больше искать
            if (mid == end) {
                return -1;
            }

            // Есть где искать, и это не края - ищем дальше
            if (target < nums[mid]) {
                // Искомое в левой части
                return binarySearchTarget(nums, start, mid, target);
            } else if (target > nums[mid]) {
                // Искомое в правой части
                return binarySearchTarget(nums, mid, end, target);
            } else {
                return mid;
            }
        }
    }
}
