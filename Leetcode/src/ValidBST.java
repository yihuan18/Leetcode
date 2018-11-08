/*
* 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
* 假设一个二叉搜索树具有如下特征：
* 节点的左子树只包含小于当前节点的数。
* 节点的右子树只包含大于当前节点的数。
* 所有左子树和右子树自身必须也是二叉搜索树。
* */
public class ValidBST {
    private double lastValue = Double.NEGATIVE_INFINITY;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(!isValidBST(root.left))
            return false;
        if(lastValue >= root.val)
            return false;
        else lastValue = root.val;
        if(!isValidBST(root.right))
            return false;
        return true;
    }

    public static void main(String[] args){
        ValidBST validBST = new ValidBST();
        TreeNode root = new TreeNode(0);
        //root.left = new TreeNode(1);
        //root.right = new TreeNode(3);
        boolean b = validBST.isValidBST(root);
        System.out.print(b);
    }
}
