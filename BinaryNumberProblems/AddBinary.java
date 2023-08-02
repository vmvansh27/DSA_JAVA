
// https://leetcode.com/problems/add-binary/description/
public class AddBinary {

    // -> Does not pass some test cases due to high value of Input that Int cannot
    // store
    // public static String addBinaryApproach2(String a, String b) {
    // int num1, num2, sum;
    // num1 = Integer.parseInt(a,2);
    // num2 = Integer.parseInt(b,2);
    // sum = num1 + num2;
    // String result = Integer.toBinaryString(sum);
    // return result;
    // }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            if (sum == 0 || sum == 1) {
                result.append(sum);
                carry = 0;
            } else if (sum == 2) {
                result.append(0);
                carry = 1;
            } else {
                result.append(1);
                carry = 1;
            }
            i--;
            j--;
        }

        if (carry == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String x = "011011";
        String y = "1010111";
        // Output should be 1110010
        System.out.println("Expected Output: 1110010, Your output = " + addBinary(x, y));
    }
}
