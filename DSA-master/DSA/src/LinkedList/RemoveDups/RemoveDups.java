package LinkedList.RemoveDups;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveDups {
    public static void main(String[] args) {

        insert(1);
        insert(1);
        insert(2);
        insert(3);
        insert(3);

        print();
    }

    static ListNode head = null;

    private static void insert(int val) {
        ListNode node = new ListNode(val);

        if (head == null) {
            head = node;
        } else {
            ListNode n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    private static void removeDups() {

    }

    private static void print() {
        ListNode n = head;
        while(n != null) {
            System.out.print(n.val + " => ");
            n = n.next;
        }
        System.out.println();
    }
}
