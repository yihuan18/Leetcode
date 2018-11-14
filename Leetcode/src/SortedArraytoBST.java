/*
Leetcode Q108 : 将有序数组转化为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedArraytoBST {
    private int[] global_nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        TreeNode root;
        global_nums = nums;
        root = createTree(0 , nums.length - 1);
        return root;
    }

    private TreeNode createTree(int start , int end){
        if(start == end) {
            return new TreeNode(global_nums[start]);
        }
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(global_nums[mid]);
        if((mid - 1) >= start)
            node.left = createTree(start , mid - 1);
        if((mid + 1) <= end)
        node.right = createTree(mid + 1 , end);
        return node;
    }

    public static void main(String[] args){
        int[] nums = {-10,-3,0,5,9};
        SortedArraytoBST bst = new SortedArraytoBST();
        TreeNode root = bst.sortedArrayToBST(nums);
        System.out.print(root);
    }
}
