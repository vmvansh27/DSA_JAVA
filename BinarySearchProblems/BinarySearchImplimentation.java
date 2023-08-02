
public class BinarySearchImplimentation {
    public static void main(String[] args) {
        int[] arr = { -1, 2, 4, 5, 6, 8, 9, 10 };
        int target = 10;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // It is same as start+end/2 but the upgraded formula wont affect
                                                 // integer size

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
