// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/?

public class FinalValueOfVariableAfterPerformingOperations {

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.contains("+"))
                x++;
            else
                x--;
        }
        return x;
    }

    public static void main(String[] args) {
        String[] operations = { "--X", "X++", "X++" };
        int result = finalValueAfterOperations(operations);
        System.out.println("Expected Output: 1");
        System.out.println("Output:" + result);
    }
}
