package LinkedList.Reverse;


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Reverse {
    public static void main(String[] args) {

        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);

        ListNode rev = reverse(head);
        head = rev;
        print();
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

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, present = head, next = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }

        return prev;
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
