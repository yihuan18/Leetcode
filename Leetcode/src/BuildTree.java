/*
Leetcode Q105 : 从前序与中序中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
 */
import java.util.Arrays;

public class BuildTree {
    private int index = 0;
    private int[] global_preorder;
    private int[] global_inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        global_preorder = preorder;
        global_inorder = inorder;
        int val = preorder[index];
        int rootIndex = 0;
        for(; rootIndex < global_inorder.length ; rootIndex++){
            if(val == global_inorder[rootIndex])
                break;
        }
        TreeNode ret = new TreeNode(val);
        if(++index == global_preorder.length)
            return ret;
        createTree(ret ,0 ,rootIndex-1 , rootIndex+1 , inorder.length-1);
        return ret;
    }

    private void createTree(TreeNode head, int left_start,int left_end,int right_start,int right_end){
        if(left_end - left_start + 1 > 0){
            int val = global_preorder[index];
            head.left = new TreeNode(val);
            if(++index == global_preorder.length)
                return;
            int rootIndex = 0;
            for(; rootIndex < global_inorder.length ; rootIndex++){
                if(val == global_inorder[rootIndex])
                    break;
            }
            createTree(head.left,left_start,rootIndex-1,rootIndex+1,left_end);
        }
        if(right_end - right_start + 1 > 0){
            int val = global_preorder[index];
            head.right = new TreeNode(val);

            if(++index == global_preorder.length)
                return;
            int rootIndex = 0;
            for(; rootIndex < global_inorder.length ; rootIndex++){
                if(val == global_inorder[rootIndex])
                    break;
            }
            createTree(head.right,right_start,rootIndex-1,rootIndex+1,right_end);
        }
    }


    public static void main(String[] args){
        BuildTree buildTree = new BuildTree();
        int preorder[] = {3,9,20,15,7};
        int inorder[] = {9,3,15,20,7};
        TreeNode ret = buildTree.buildTree(preorder,inorder);
        System.out.println(ret);
    }

}
