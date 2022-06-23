package Trees.BalanceBT;

// if height(left) - height(right) <= 1 then balanced else not balanced;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class Main {
    static int isBalanced(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = isBalanced(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = isBalanced(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(8);
//        root.left.left.left = new Node(2);

        System.out.println(isBalanced(root) != -1);
    }
}
