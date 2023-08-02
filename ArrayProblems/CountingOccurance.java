class CountingOccurance {
    public static void main(String[] args) {
        int n = 12321321;
        int findVal = 1;
        int counter = 0;
        while (n != 0) {
            int currVal = n % 10;
            n /= 10;
            if (currVal == findVal) {
                counter++;
            }
        }
        System.out.println(counter);

    }
}