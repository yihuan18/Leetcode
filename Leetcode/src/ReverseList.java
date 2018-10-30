import java.util.List;

public class ReverseList {
    ListNode reverseNode;
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode currentNode = getLast(head);
        currentNode.next = null;
        return reverseNode;
    }

    private ListNode getLast(ListNode node){
        ListNode currentNode = node;
        if(node.next == null){
            reverseNode = node;
            return node;
        }else node = node.next;
        ListNode last = getLast(node);
        last.next = currentNode;
        return currentNode;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ReverseList reverseList = new ReverseList();
        reverseList.reverseList(head);
        System.out.print("");
    }
}
