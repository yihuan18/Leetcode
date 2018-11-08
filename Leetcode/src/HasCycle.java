public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head,slow = head;
        if(head == null)
            return false;
        while(true){
            slow = slow.next;
            if(fast.next == null || slow == null)
                return false;
            fast = fast.next.next;
            if(fast == null)
                return false;
            if(slow == fast)
                return true;
        }
    }

    public static void main(String[] args){

    }
}
