/*
leetcode Q94 : 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。
 */
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    List<Integer> ret = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return ret;
        if(root.left != null)
            inorderTraversal(root.left);
        ret.add(root.val);
        if(root.right != null)
            inorderTraversal((root.right));
        return ret;
    }
}
