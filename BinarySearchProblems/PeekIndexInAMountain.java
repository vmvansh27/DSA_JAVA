// https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class PeekIndexInAMountain {
    public static void main(String[] args) {
        int[] arr = { 0, 2, 1, 0 };
        System.out.println(mountainPeek(arr));
    }

    public static int mountainPeek(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
