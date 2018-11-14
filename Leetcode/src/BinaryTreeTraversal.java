/*
LeetCode Q102:
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list1 = new ArrayList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        list1.add(root.val);
        ret.add(list1);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int num = queue.size();
            for(int i = 0 ; i < num ; i++){
                TreeNode current = ((LinkedList<TreeNode>) queue).pop();
                if(current.left != null){
                    ((LinkedList<TreeNode>) queue).addLast(current.left);
                    list.add(current.left.val);
                }
                if(current.right != null){
                    ((LinkedList<TreeNode>) queue).addLast(current.right);
                    list.add(current.right.val);
                }
            }
            if(list.isEmpty())
                break;
            ret.add(list);
        }
        return ret;
    }
}
