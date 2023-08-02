// https://leetcode.com/problems/sum-multiples/description/
public class SumMultiples {

    public static int sumOfMultiples(int n) {
        int sum = 0;
        while (n != 0) {
            if (n % 3 == 0 || n % 5 == 0 || n % 7 == 0) {
                sum += n;
            }
            n--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfMultiples(7));
    }
}
