
// https://leetcode.com/problems/sort-colors/
import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;

        for (int num : nums) {
            if (num == 0)
                zero++;
            if (num == 1)
                one++;
            if (num == 2)
                two++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zero != 0) {
                nums[i] = 0;
                zero--;
            } else if (one != 0) {
                nums[i] = 1;
                one--;
            } else {
                nums[i] = 2;
                two--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 2, 1, 2, 0, 2, 1, 1 };
        System.out.println("Before: " + Arrays.toString(nums));
        sortColors(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }
}
