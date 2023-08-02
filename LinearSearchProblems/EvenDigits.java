// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/


public class EvenDigits {
    public static void main(String[] args) {
        int[] arr = { 12, 345, 2, 6, 7896 };

        System.out.println(findNumbers(arr));
    }

    static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (evenNumber(num))
                count++;
        }
        return count;
    }

    // Works same as evenNumber
    // static boolean evenNumber2(int num) {
    // if (num < 0) {
    // num = num * -1; // If the number is negative then convert it into positive
    // }
    // int even = (int) (Math.log10(num)) + 1; //Shortcut method to find number of
    // digits
    // return even % 2 == 0;
    // }

    static boolean evenNumber(int num) {
        if (num < 0) {
            num = num * -1; // If the number is negative then convert it into positive
        }

        if (num == 0) {
            return false;
        }

        int numOfDigits = 0;
        while (num > 0) {
            num /= 10;
            numOfDigits++;
        }
        return numOfDigits % 2 == 0;
    }
}
