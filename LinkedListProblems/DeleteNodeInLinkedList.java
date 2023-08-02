// https://leetcode.com/problems/delete-node-in-a-linked-list/description/
public class DeleteNodeInLinkedList {
    node head;

    public static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertFirst(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void printList(String s) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        node currNode = head;
        System.out.print(s);
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public void deleteNode(node nodeToBeDeleted) {

        node forward = nodeToBeDeleted.next;
        while (forward.next != null) {
            nodeToBeDeleted.data = forward.data;
            nodeToBeDeleted = nodeToBeDeleted.next;
            forward = forward.next;
        }
        nodeToBeDeleted.data = forward.data;
        nodeToBeDeleted.next = null;
    }

    public void deleteNodeMethod2(node nodeToBeDeleted) {

        nodeToBeDeleted.data = nodeToBeDeleted.next.data;
        nodeToBeDeleted.next = nodeToBeDeleted.next.next;
    }

    public static void main(String[] args) {
        DeleteNodeInLinkedList list = new DeleteNodeInLinkedList();
        list.insertFirst(9);
        list.insertFirst(1);
        list.insertFirst(5);
        list.insertFirst(4);

        list.printList("Before Deletion = ");

        // list.deleteNode(list.head.next);

        // Method 2 will work if and only if there are 4 elements in the list. It won't
        // work if node to be deleted is the last element of list

        list.deleteNodeMethod2(list.head.next);

        list.printList("After Deletion = ");
    }
}