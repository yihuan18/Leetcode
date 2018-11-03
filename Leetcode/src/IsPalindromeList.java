import java.util.Stack;

public class IsPalindromeList {
    public boolean isPalindrome_YIHUAN(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode iterator = head;
        while(iterator != null){
            stack.push(iterator.val);
            iterator = iterator.next;
        }
        while(!stack.empty()){
            if(head.val != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        int len = 0;
        while (current != null) {
            len++;
            current = current.next;
        }

        if (len == 0 || len == 1) {
            return true;
        }

        boolean odd = (len % 2 == 1);
        int halfLen = len / 2;

        current = head;
        ListNode temp = null;
        ListNode newHead = head;
        for (int i = 1; i < halfLen; i++) {
            temp = current.next;
            current.next = temp.next;
            temp.next = newHead;
            newHead = temp;
        }

        if (odd) {
            temp = current.next.next;
        } else {
            temp = current.next;
        }
        current = newHead;

        for (int i = 0; i < halfLen; i++) {
            if (current.val != temp.val) {
                return false;
            }
            current = current.next;
            temp = temp.next;
        }

        return true;
    }
}
