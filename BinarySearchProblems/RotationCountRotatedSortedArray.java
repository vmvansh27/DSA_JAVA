// https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/

public class RotationCountRotatedSortedArray {
    public static void main(String[] args) {
        // input:arr = {15, 18, 2, 3, 6, 12}
        // output: 2
        // int[] arr = { 15, 18, 2, 3, 6, 12 };
        // int arr[] = { 7, 9, 11, 12, 5 };
        int arr[] = { 7, 9, 11, 12, 15 };
        int ans = pivot(arr);
        System.out.println(ans + 1);

        // if array is not rotated then pivot will return -1, -1+1 = 0 => answer
    }

    static int pivot(int[] nums) {
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
}
