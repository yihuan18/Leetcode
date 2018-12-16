/*
Leetcode Q103 : 二叉树的锯齿形层次遍历（广度遍历）
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null)
            return ret;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<TreeNode> nodeStack1 = new Stack<>();
        nodeStack.push(root);
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        ret.add(first);

        int fromLeft = 0;
        //不需要便利顺序不同，只是插入顺序不同即可，一个从list的尾部插入，一个从list的头部插入，即表现为遍历的顺序不同
        while(!nodeStack.empty() || !nodeStack1.empty()){
            if(fromLeft == 1){
                List<Integer> level = new ArrayList<>();
                nodeStack.clear();
                while(!nodeStack1.empty()){
                    TreeNode current = nodeStack1.pop();
                    if(current.left != null) {
                        level.add(current.left.val);
                        nodeStack.push(current.left);
                    }
                    if(current.right != null){
                        level.add(current.right.val);
                        nodeStack.push(current.right);
                    }
                }//end while (!nodeStack1.empty())
                if(level.size() != 0)
                    ret.add(level);
                fromLeft = 0;
            }
            else{
                List<Integer> level = new ArrayList<>();
                nodeStack1.clear();
                while(!nodeStack.empty()){
                    TreeNode current = nodeStack.pop();
                    if(current.right != null) {
                        level.add(current.right.val);
                        nodeStack1.push(current.right);
                    }
                    if(current.left != null){
                        level.add(current.left.val);
                        nodeStack1.push(current.left);
                    }

                }//end while (!nodeStack.empty())
                if(level.size() != 0)
                    ret.add(level);
                fromLeft = 1;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        TreeNode head = TreeNode.createTree(new int[]{3,9,20,0,0,15,7});
        ZigZagLevelOrder zzlo = new ZigZagLevelOrder();
        List<List<Integer>> ret;
        ret = zzlo.zigzagLevelOrder(head);
        System.out.println(ret);
    }
}
