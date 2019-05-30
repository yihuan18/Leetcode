public class Q142RecycleList {
    public ListNode detectCycle(ListNode head) {
        //1 判断是否有环 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            fast = fast.next;
            if(fast == null)
                return null;
            fast = fast.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast == null)
            return null;

        //2 判断环的长度
        int count = 1;
        slow = slow.next;
        while (slow != fast){
            slow = slow.next;
            count++;
        }

        //3 找到环的起点 先后指针 先指针先走length步
        ListNode before = head;
        ListNode after = head;
        for(int i = 0 ; i < count ; i++){
            before = before.next;
        }
        while (before != after){
            before = before.next;
            after = after.next;
        }

        return after;
    }
}
