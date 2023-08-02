
import java.util.*;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
public class converBinaryNoInLinkedListToInt {

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();

        ll.add("1");
        ll.add("0");
        ll.add("1");

        String binaryNumberStr = "";
        int i = 0;
        while (i < ll.size()) {
            binaryNumberStr += ll.get(i);
            i++;
        }
        int binary = Integer.parseInt(binaryNumberStr, 2);
        // For this logic refer here :
        // https://www.javatpoint.com/java-binary-to-decimal
        System.out.println(binary);
    }
}
