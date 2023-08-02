// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class RotatedSortedArray {
    public static void main(String[] args) {
        // Input: nums = [4,5,6,7,0,1,2], target = 0
        // Output: 4
        int nums[] = { 15, 18, 2, 3, 6, 12 };
        int target = 0;
        int ans = search(nums, target);
        System.out.println(ans);
    }

    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if (nums[pivot] == target) {
            return pivot;
        }
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);

    }

    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

    // // For Duplicate elements in array
    // static int findPivot(int[] nums) {
    // int start = 0;
    // int end = nums.length - 1;
    // while (start <= end) {
    // int mid = start + (end - start) / 2;

    // if (mid < end && nums[mid] > nums[mid + 1]) {
    // return mid;
    // }
    // if (mid > start && nums[mid] < nums[mid - 1]) {
    // return mid - 1;
    // }
    // // if elements at middle, start, end are equal then just skip the duplicates
    // if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
    // // skip the duplicates
    // // Note: what if these elements at start and end were the pivot?
    // // check if start is pivot
    // if (nums[start] > nums[start + 1]) {
    // return start;
    // }
    // start++;

    // // check whether end is pivot
    // if (nums[end] < nums[end - 1]) {
    // return end - 1;
    // }
    // end--;
    // }

    // // left side is sorted, so pivot should be in right
    // else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] >
    // nums[end])){
    // start = mid + 1;
    // } else {
    // end = mid - 1;
    // }

    // }
    // return -1;
    // }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
