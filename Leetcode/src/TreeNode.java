import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        val = x;
    }

    //vals == 0 regarded as no node here
    public static TreeNode createTree(int[] vals){
        TreeNode head = new TreeNode(vals[0]);
        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> level1 = new ArrayList<>();
        level.add(head);
        int index = 1;
        while(index < vals.length){
            for(int i = 0 ; i < level.size() ; i++) {

                TreeNode current = level.get(i);
                if(vals[index] != 0) {
                    current.left = new TreeNode(vals[index]);
                    level1.add(current.left);
                }
                else current.left = null;

                index++;
                if(index == vals.length)
                    break;

                if(vals[index] != 0) {
                    current.right = new TreeNode(vals[index]);
                    level1.add(current.right);
                }
                else current.right = null;
                index++;
                if(index == vals.length)
                    break;
            }
            level.clear();
            level.addAll(level1);
        }
        return head;
    }

    public static void main(String[] args){
        TreeNode head = createTree(new int[]{3,9,20,0,0,15,7});
        System.out.println("heihei");
    }
}
