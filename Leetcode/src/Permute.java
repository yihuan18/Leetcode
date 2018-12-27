/*
Leetcode Q46 : 全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length == 0)
            return ret;
        Integer[] sequence = new Integer[nums.length];
        boolean[] taken = new boolean[nums.length];
        arrange(0,sequence,nums,taken,ret);
        return ret;
    }

    public void arrange(int level , Integer[] sequence , int[] nums , boolean[] taken , List<List<Integer>> ret){
        for(int i = 0 ; i < nums.length ; i++){
            if(taken[i])
                continue;
            taken[i] = true;
            sequence[level] = nums[i];
            if(level == (nums.length - 1)) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(Arrays.asList(sequence));
                ret.add(temp);
                taken[i] = false;
                return;
            }
            else arrange(level + 1 , sequence , nums , taken , ret);
            taken[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> ret;
        ret = permute.permute(new int[]{1,2,3});
        System.out.println(ret);
    }


}
