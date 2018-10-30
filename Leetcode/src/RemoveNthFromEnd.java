import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode last = head;
        for(int i = 0 ; i < n ; i++){
            first = first.next;
        }
        if(first == null){
            head = head.next;
            return head;
        }
        while(first.next != null){
            first = first.next;
            last = last.next;
        }
        last.next = last.next.next;
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        removeNthFromEnd.removeNthFromEnd(head,2);
        while(head.next != null){
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }
}
