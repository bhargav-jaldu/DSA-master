package Trees.Height;


import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class Height {

//    Level Order (BFS)
    private static void height(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size != 0) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }

            height++;
        }

        System.out.println("Height of a binary tree is: " + height);
    }

    private static int heightDFS(Node root) {
        if (root == null) {
            return 0;
        }

        int left = heightDFS(root.left);
        int right = heightDFS(root.right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(8);

        height(root);
        System.out.println(heightDFS(root));
    }
}
