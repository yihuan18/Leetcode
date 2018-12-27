/*
Leetcode Q78 : 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
 */
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        for(int i = 0 ; i < nums.length ; i++){
            int[] sequence = new int[i+1];
            subsetsOfN(nums,sequence,0,-1,i+1,ret);
        }
        return ret;
    }

    public void subsetsOfN(int[] nums , int[] sequence, int level , int lastIndex , int n , List<List<Integer>> ret){
        for(int i = lastIndex+1 ; i <= (nums.length - n + level) ; i++){
            sequence[level] = nums[i];
            if(level == (n -1)){
                List<Integer> temp = new ArrayList<>();
                for(int element : sequence) temp.add(element);
                ret.add(temp);
            }
            else subsetsOfN(nums,sequence,level + 1,i,n,ret);
        }
    }



    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> ret;
        ret = subsets.subsets(new int[]{1,2,3});
        System.out.println(ret);
    }

}
