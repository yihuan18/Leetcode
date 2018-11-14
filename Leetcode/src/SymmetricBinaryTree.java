import java.util.*;
/*
LeetCode Q101:
给定一个二叉树，检查它是否是镜像对称的。
如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class SymmetricBinaryTree {
    /* 递归求解法
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmertic(root.left,root.right);
    }

    private boolean isSymmertic(TreeNode left,TreeNode right){
        if(left == null || right == null){
            return left == right;
        }

        return left.val == right.val
            &&isSymmertic(left.left,right.right)
            &&isSymmertic(left.right,right.left);
    }
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        while (!queue.isEmpty()){
            int num = queue.size();
            for(int i = 0 ; i < num ; i++){
                TreeNode current = ((LinkedList<TreeNode>) queue).pop();
                if(current.left != null){
                    ((LinkedList<TreeNode>) queue).addLast(current.left);
                    list.add(current.left.val);
                }else list.add(null);
                if(current.right != null){
                    ((LinkedList<TreeNode>) queue).addLast(current.right);
                    list.add(current.right.val);
                }else list.add(null);
            }
            //判断list是否对称
            if(!isSymmetricList(list))
                return false;
            list.clear();
        }
        return true;
    }

    private boolean isSymmetricList(List<Integer> list){
        int length = list.size();
        int last = length  - 1;
        for(int i = 0 ; i < length/2 ; i++){
            if(list.get(i) != list.get(last))
                return false;
            last--;
        }
        return true;
    }

    public static void main(String[] args){

    }
}
