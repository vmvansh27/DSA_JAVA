
// https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/

public class DifferenceBetweenElementSumAndDigitSumArray {

    public static int differenceOfSum(int[] nums) {

        int element = 0;
        int digits = 0;

        for (int num : nums) {
            element += num;
            while (num > 0) {
                digits += num % 10;
                num /= 10;
            }
        }
        return element - digits;
    }

    public static void main(String[] args) {

        int[] nums = { 5, 8, 11, 4 };

        int result = differenceOfSum(nums);
        // Sum of element should be 5 + 8 + 11 + 2 = 26
        // Digit Sum should be 5 + 8 + 1 + 1 + 2 = 17
        // And result should be element - digit that is = 26 - 17 = 9
        System.out.println(result);
    }
}
