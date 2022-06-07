package LinkedList.Middle;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Middle {
    public static void main(String[] args) {

        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);

        print();
        ListNode slow = middle();
    }

    static ListNode head = null;
    private static void insert(int val) {
        ListNode node = new ListNode(val);

        if (head == null) {
            head = node;
        }
        else {
            ListNode n = head;
            while(n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    private static ListNode middle() {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
