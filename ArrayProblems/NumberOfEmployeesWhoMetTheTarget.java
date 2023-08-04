public class NumberOfEmployeesWhoMetTheTarget {
    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int n : hours) {
            if (n >= target)
                count++;
        }
        return count;

    }

    public static void main(String[] args) {
        int[] hours = { 0, 1, 2, 3, 4 };
        int target = 2;
        System.out.println("Number of employees who met the target: " + numberOfEmployeesWhoMetTarget(hours, target));
    }
}
