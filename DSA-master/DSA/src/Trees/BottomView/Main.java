package Trees.BottomView;

import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

class Tuple {
    Node node;
    int y;
    Tuple(Node node, int y) {
        this.node = node;
        this.y = y;
    }
}

public class Main {
    static void bottomView(Node root) {
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0));

        TreeMap<Integer, Integer> map = new TreeMap<>();

        while(!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            Node node = tuple.node;
            int y = tuple.y;

            map.put(y, node.data);

            if (node.left != null) {
                queue.add(new Tuple(node.left, y - 1));
            }

            if (node.right != null) {
                queue.add(new Tuple(node.right, y + 1));
            }
        }

        System.out.println(map);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.print(entry.getValue() + ", ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        bottomView(root);
    }
}
