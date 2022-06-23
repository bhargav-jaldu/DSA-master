package Trees.Diameter;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class Main {

    public static int diameterOfBinaryTree(Node root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private static int height(Node node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(8);
        root.left.right.right = new Node(10);

        System.out.println(diameterOfBinaryTree(root));
    }
}