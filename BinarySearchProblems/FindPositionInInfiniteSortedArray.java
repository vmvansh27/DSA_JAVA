// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

class FindPositionInInfiniteSortedArray {
    public static void main(String[] args) {
        int arr[] = new int[] { 3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170 };
        int ans = ans(arr, 10);

        if (ans == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + ans);
    }

    static int ans(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return search(arr, target, start, end);
    }

    static int search(int[] arr, int target, int start, int end) {
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