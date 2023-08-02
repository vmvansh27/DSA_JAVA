// https://leetcode.com/problems/find-in-mountain-array/

public class FindPeakInMountainHard {
    public static void main(String[] args) {
        // array = [1,2,3,4,5,3,1], target = 3
        // Output: 2

        int[] arr = { 1, 2, 3, 4, 5, 3, 1 };
        int target = 3;
        int ans = search(arr, target);
        System.out.println(ans);
    }

    public static int search(int[] nums, int target) {
        int peek = mountainPeek(nums);
        int firstTry = orderAgnostic(nums, target, 0, peek);
        if (firstTry != -1) {
            return firstTry;
        }
        return orderAgnostic(nums, target, peek, nums.length - 1);
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

    static int orderAgnostic(int[] arr, int target, int start, int end) {

        boolean isAsc = arr[start] < arr[end]; // to check if it is in asc or desc
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }
            // For ascending order
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // For descending order
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
