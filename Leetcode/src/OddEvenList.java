/*
Leetcode Q328 : 奇偶链表
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next , even_start = head.next;
        if(even == null)
            return head;
        if(even.next == null)
            return head;
        while(odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            if(odd.next != null){
                even.next = odd.next;
                even = even.next;
            }
        }
        even.next = null;
        odd.next = even_start;
        return head;
    }
    public static void  main(String[] args){
        OddEvenList oel = new OddEvenList();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        ListNode input = new ListNode(0);
        ListNode head = input;
        for(int i : nums){
            input.next = new ListNode(i);
            input = input.next;
        }
        ListNode ret = oel.oddEvenList(head.next);
        while (ret != null){
            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }
}
