// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class FindFIrstAndLastPositionOfElement {
    public static void main(String[] args) {
        int[] arr = { -1, 2, 2, 2, 2, 8, 9, 10 };
        int target = 2;
        int[] solution = searchRange(arr, target);
        for (int element : solution) {
            System.out.println(element);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] arr = { -1, -1 };
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        arr[0] = start;
        arr[1] = end;
        return arr;
    }

    public static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // Found the potential ans
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
