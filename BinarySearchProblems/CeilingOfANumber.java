// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=26

public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 9, 14, 16, 18 };
        // int[] nums = { -1, 2, 4, 5, 6, 8, 9, 19 };
        int target = 1;
        System.out.println(ceiling(nums, target));
    }

    // return the index: smallest number >= target
    static int ceiling(int[] nums, int target) {

        // but what if the target is greater than the greatest number in the array
        if (target > nums[nums.length - 1]) {
            return -1;
        }

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
        return start;
    }
}
