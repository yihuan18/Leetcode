/*
LeetCode Q116 : 填充同一层的兄弟节点
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
 */
import java.util.ArrayList;
import java.util.List;

public class ConnectTreeLinkNode {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        if(root.left == null) {
            root.next = null;
            return;
        }
        root.next = null;
        connectTree(root.left,root.right);
    }

    public void connectTree(TreeLinkNode left , TreeLinkNode right){
        if(left.left == null) {
            left.next = right;
            right.next = null;
            return;
        }
        connectTree(left.left,left.right);
        connectTree(left.right,right.left);
        connectTree(right.left,right.right);
        left.next = right;
        right.next = null;
    }

    /*
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left != null)
            root.left.next = root.right;
        if(root.right != null){
            if(root.next !=null)
                root.right.next = root.next.left;
            else
                root.right.next = null;
        }
        connect(root.left);
        connect(root.right);
    }
     */
}
