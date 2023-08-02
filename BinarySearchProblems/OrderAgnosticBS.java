
public class OrderAgnosticBS {
    public static void main(String[] args) {
        // int[] arr = { -1, 2, 4, 5, 6, 8, 9, 10 };
        int[] arr = { 10, 8, 6, 4, 3, 2, 1 };
        int target = 8;
        int ans = orderAgnostic(arr, target);
        System.out.println(ans);
    }

    static int orderAgnostic(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end]; // to check if it is in asc or desc
        while (start <= end) {
            int mid = start + (end - start) / 2; // It is same as start+end/2 but the upgraded formula wont affect //
                                                 // integer size

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
