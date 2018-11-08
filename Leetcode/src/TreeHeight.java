import java.util.ArrayList;
import java.util.List;

public class TreeHeight {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root,0);
    }

    private int dfs(TreeNode node , Integer depth){
        int height_left = 0,height_right = 0;
        if(node.left == null && node.right == null)
            return depth + 1;
        if(node.left != null)
            height_left = dfs(node.left , depth + 1);
        if(node.right != null)
            height_right = dfs(node.right , depth + 1);
        return Math.max(height_left,height_right);
    }

/* Leetcode Answer
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        int maxLeft = maxDepth(root.left) + 1;
        int maxRight = maxDepth(root.right) + 1;

        return  maxLeft > maxRight ? maxLeft : maxRight;

    }
*/

    public static void main(String[] args){

    }
}
