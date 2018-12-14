/*
LeetCode Q160 : 相交链表
编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
        ListNode pA = headA , pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
