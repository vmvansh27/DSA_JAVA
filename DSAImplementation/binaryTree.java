import java.util.*;

public class binaryTree {

    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class bt {
        static int index = -1;

        public node buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            node newNode = new node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

    }

    public static void preOrder(node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(node root) {
        if (root == null) {
            return;
        }
        Queue<node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countNode(node root) {
        if (root == null) {
            return 0;
        }
        int leftNode = countNode(root.left);
        int rigthNode = countNode(root.right);
        return leftNode + rigthNode + 1;
    }

    public static int sumOfNodes(node root) {
        if (root == null) {
            return 0;
        }

        int leftNodeSum = sumOfNodes(root.left);
        int rightNodeSum = sumOfNodes(root.right);
        return root.data + leftNodeSum + rightNodeSum;
    }

    public static int heightOfTree(node root) {
        if (root == null) {
            return 0;
        }
        int leftNode = heightOfTree(root.left);
        int rightNode = heightOfTree(root.right);
        return Math.max(leftNode, rightNode) + 1;
    }

    // To find diameter of tree in O(n^2)
    public static int diameterOfTree(node root) {
        if (root == null) {
            return 0;
        }
        int diam1 = diameterOfTree(root.left);
        int diam2 = diameterOfTree(root.right);
        int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));

    }

    // To find diamter of tree in O(N)
    static class treeInfo {
        int height;
        int diameter;

        treeInfo(int ht, int diam) {
            this.height = ht;
            this.diameter = diam;
        }
    }

    public static treeInfo diameter2(node root) {
        if (root == null) {
            return new treeInfo(0, 0);
        }
        treeInfo left = diameter2(root.left);
        treeInfo right = diameter2(root.right);

        int height = Math.max(left.height, right.height) + 1;

        int diam1 = left.diameter;
        int diam2 = right.diameter;
        int diam3 = left.height + right.height + 1;

        int diameter = Math.max(Math.max(diam1, diam2), diam3);

        treeInfo myInfo = new treeInfo(height, diameter);
        return myInfo;
    }

    public static int sumOfNodesAtKthLevel(node root, int k) {
        if (root == null) {
            return 0;
        }
        Queue<node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;
        int sum = 0;
        while (!q.isEmpty()) {
            node currNode = q.remove();
            if (currNode == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    level++;
                    if (level > k) {
                        break;
                    }
                }
            } else if (level == k) {
                sum += currNode.data;
            } else {
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        bt tree = new bt();
        node root = tree.buildTree(nodes);
        // System.out.print("preOrder = ");
        // preOrder(root);
        // System.out.println("\n Lever Order = ");
        // levelOrder(root);

        // System.out.println(countNode(root)); // to calculate no. of nodes in a tree;

        // System.out.println(sumOfNodes(root));

        // System.out.println(heightOfTree(root));

        // System.out.println(diameterOfTree(root));

        // System.out.println(diameter2(root).diameter);

        System.out.println(sumOfNodesAtKthLevel(root, 3));
    }
}