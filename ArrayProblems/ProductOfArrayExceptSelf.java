
// https://leetcode.com/problems/product-of-array-except-self/description/

public class ProductOfArrayExceptSelf {
    public static void poaExceptSelf(int[] nums) {
        int size = nums.length;
        int[] left = new int[size];
        int[] right = new int[size];
        int[] prod = new int[size];

        left[0] = 1;
        right[size - 1] = 1;

        for (int i = 1; i < size; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        for (int i = size - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        for (int i = 0; i < size; i++) {
            prod[i] = left[i] * right[i];
        }

        // Printing Result->
        for (int i = 0; i < size; i++) {
            System.out.print(prod[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        int[] nums = { 1, 2, 3, 4 };
        // Output Should be [24, 12, 8, 6]
        poaExceptSelf(nums);
    }
}