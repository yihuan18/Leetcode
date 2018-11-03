//LeetCode Q21
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode head = ret;
        ListNode pointer1 = l1 , pointer2 = l2;
        while(pointer1 != null && pointer2 != null){
            if(pointer1.val < pointer2.val){
                ret.next = new ListNode(pointer1.val);
                ret = ret.next;
                pointer1 = pointer1.next;
            }
            else if(pointer1.val == pointer2.val){
                ret.next = new ListNode(pointer1.val);   //new一个 而不是直接赋值引用
                ret = ret.next;
                ret.next = new ListNode(pointer2.val);
                ret = ret.next;
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            else{
                ret.next = new ListNode(pointer2.val);
                ret = ret.next;
                pointer2 = pointer2.next;
            }
        }
        if(pointer1 != null)
            ret.next = pointer1;
        if(pointer2 != null)
            ret.next = pointer2;
        return head.next;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode ret = mergeTwoLists.mergeTwoLists(head,head1);
        System.out.print(ret);
    }
}
