package offeroffer;

public class ReverseListII {
    private int count;

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode before;
        ListNode tail_temp;
        ListNode current = head;
        ListNode pre = null;

        //search for head
        int count = 1;
        while (count < m) {
            pre = current;
            current = current.next;
            count++;
        }
        tail_temp = current;
        before = pre;

        ListNode next = current.next;
        //reverse list
        while (count < n) {
            pre = current;
            current = next;
            next = current.next;
            current.next = pre;
            count++;
        }

        //recombine list
        if (before != null) {
            before.next = current;
            tail_temp.next = next;
        } else {
            head = current;
        }

        return head;
    }

    public ListNode reverseBetween_good(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
