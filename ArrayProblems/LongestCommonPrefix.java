
// https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        String result = "";

        for (int i = 1; i < strs.length; i++) {
            for (int a = 0; a < strs[i].length() && a < prefix.length(); a++) {
                if (prefix.charAt(a) == strs[i].charAt(a)) {
                    result += prefix.charAt(a);
                } else {
                    break;
                }
            }
            prefix = result;
            result = "";
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "fl" };
        String result = longestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + result);

    }
}
