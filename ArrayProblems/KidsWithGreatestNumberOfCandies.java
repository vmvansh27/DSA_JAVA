
import java.util.*;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/

public class KidsWithGreatestNumberOfCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int highest = 0;
        List<Boolean> li = new ArrayList<>(candies.length);
        for (int candy : candies) {
            if (candy > highest)
                highest = candy;
        }
        for (int candy : candies) {
            int extra = candy + extraCandies;
            if (extra >= highest) {
                li.add(true);
            } else
                li.add(false);
        }
        return li;
    }

    public static void main(String[] args) {
        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        List<Boolean> li = new ArrayList<Boolean>(candies.length);
        li = kidsWithCandies(candies, extraCandies);

        System.out.println("Expected Output: [true, true, true, false, true]" + " Output = " + li);
    }
}
