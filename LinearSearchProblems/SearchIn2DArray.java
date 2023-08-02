
import java.util.Arrays;

public class SearchIn2DArray {

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 4, 52, 435, 34, 34 },
                { 34, 5, 32, 56 }
        };
        int[] ans = search(arr, 52);
        System.out.println(Arrays.toString(ans));

        System.out.println("Maximum Element in array is " + max(arr));
    }

    static int[] search(int[][] arr, int search) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == search) {
                    return new int[] { row, col };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    static int max(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        return max;
    }

    static int min(int[][] arr) {
        int min = Integer.MAX_VALUE;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > min) {
                    min = anInt;
                }
            }
        }
        return min;
    }
}
