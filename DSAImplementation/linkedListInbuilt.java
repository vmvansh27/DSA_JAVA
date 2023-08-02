import java.util.*;

public class linkedListInbuilt {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        list.addFirst("a");
        list.addFirst("is");
        list.addFirst("vansh");
        list.addLast("good");
        list.addLast("boy!");
        // addLast and add are same
        System.out.println(list);
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "->");
        }
        System.out.print("null");

        list.removeFirst();
        list.removeLast();

        // list.remove(0) //will remove at index 0

    }
}
