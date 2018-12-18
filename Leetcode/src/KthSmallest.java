/*
Leetcode Q230 : 二叉搜索树中第k小的元素
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class KthSmallest {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        int ret = 0;
        if(root.left != null)
            ret = kthSmallest(root.left,k);
        if(count == k)
            return ret;

        count++;
        ret = root.val;

        if(count == k)
            return ret;

        if(root.right != null)
            ret = kthSmallest(root.right,k);
        return ret;
    }

    public static void main(String[] args){
        TreeNode root = TreeNode.createTree(new int[]{5,3,6,2,4,0,0,1});
        int k = 3;
        KthSmallest kthSmallest = new KthSmallest();
        int ret = kthSmallest.kthSmallest(root,k);
        System.out.println(ret);
    }


}
