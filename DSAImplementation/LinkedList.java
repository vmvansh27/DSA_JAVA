
/**
 * LinkedList
 */

import java.util.Scanner;

class linkedList {
    node head;
    private int size;

    linkedList() {
        this.size = 0;
    }

    class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void insertFirst(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        node currNode = head;

        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        size--;

        if (head.next == null) {
            head = null;
            return;
        }

        node currNode = head.next;
        node prev = head;
        while (currNode.next != null) {
            currNode = currNode.next;
            prev = prev.next;
        }
        prev.next = null;
    }

    public boolean searchElement(int searchh) {
        node currNode = head;
        boolean check = true;
        while (currNode.data != searchh || currNode != null) {
            currNode = currNode.next;
            if (currNode == null) {
                return check;
            }
        }
        check = false;
        return check;
    }

    public void reverseIterate() {
        if (head == null || head.next == null)
            return;

        node prevNode = head;
        node currNode = head.next;
        while (currNode != null) {
            node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public node reverseRecursive(node head) {

        if (head == null || head.next == null) {
            return head;
        }
        node newHead = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        linkedList LL = new linkedList();
        Scanner input = new Scanner(System.in);
        int choice, data;
        while (true) {
            System.out.print(
                    "1: Insert at first\n2: Insert at last\n3: Delete at first\n4: Delete at last\n5: Search Element\n6: Size of the list\n7: Print list\n8: Quit\n9: Reverse Iteratively\n10: Reverse Recursively\n>> ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the data : ");
                    data = input.nextInt();
                    LL.insertFirst(data);
                    break;

                case 2:
                    System.out.println("Enter the data : ");
                    data = input.nextInt();
                    LL.insertLast(data);
                    break;

                case 3:
                    LL.deleteFirst();
                    break;

                case 4:
                    LL.deleteLast();
                    break;

                case 5:
                    System.out.println("Enter the number to search: ");
                    data = input.nextInt();
                    boolean check = LL.searchElement(data);
                    if (check == true)
                        System.out.println("Element present!");
                    else
                        System.out.println("Not present!");
                    break;

                case 6:
                    System.out.println("Size = " + LL.size);
                    break;

                case 7:
                    LL.printList();
                    break;

                case 8:
                    input.close();
                    System.exit(0);

                case 9:
                    LL.reverseIterate();
                    break;

                case 10:
                    LL.head = LL.reverseRecursive(LL.head);
                    break;

                default:
                    System.out.println("Enter a valid number!");
                    break;
            }
        }
    }
}
