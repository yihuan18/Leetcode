/*
Leetcode Q2 : 两数相加
给出两个 非空 的链表用来表示两个非负的整数。
其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {
    //主要注意引用与指针的区别
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode ret_node = ret;
        ListNode l1_node = l1;
        ListNode l2_node = l2;
        int additional = 0;
        while(l1_node != null || l2_node !=null) {
            if (l1_node == null){
                ret_node.next = new ListNode(additional + l2_node.val);
                l2_node = l2_node.next;
            }
            else if(l2_node == null){
                ret_node.next = new ListNode(additional + l1_node.val);
                l1_node = l1_node.next;
            }else {
                ret_node.next = new ListNode(additional + l1_node.val + l2_node.val);
                l1_node = l1_node.next;
                l2_node = l2_node.next;
            }

            ret_node = ret_node.next;
            additional = ret_node.val / 10;
            ret_node.val = ret_node.val % 10;
        }
        if(additional == 1)
            ret_node.next = new ListNode(1);
        return ret.next;
    }

    public static void main(String[] args){
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode ret = atn.addTwoNumbers(l1,l2);
        while (ret != null){
            System.out.println(ret.val);
            ret = ret.next;
        }

    }
}
