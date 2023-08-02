// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=26

public class FloorOfANumber {
    public static void main(String[] args) {
        // int[] nums = { 2, 3, 5, 9, 14, 16, 18 };
        int[] nums = { -1, 2, 4, 5, 6, 8, 9, 19 };
        int target = 18;
        System.out.println(floor(nums, target));
    }

    // return the index: greatest number <= target
    static int floor(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                end = mid - 1;

            } else if (target > nums[mid]) {
                start = mid + 1;
            }
        }
        return end;
    }
}
