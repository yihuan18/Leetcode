/*
Leetcode Q347 : 前K个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> times = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length){
            int count = 1;
            while(i < (nums.length - 1) && nums[i] == nums[i+1]){
                i++;
                count++;
            }
            int insetLocation = 0;
            for( ; insetLocation < k ; insetLocation++){
                if(times.size() < (insetLocation + 1) ||(times.size() >= (insetLocation + 1) && count >= times.get(insetLocation)))
                    break;
            }
            times.add(insetLocation,count);
            ret.add(insetLocation,nums[i]);
            i++;
        }
        while(ret.size() > k){
            ret.remove(ret.size() - 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        List<Integer> ret;
        ret = topKFrequent.topKFrequent(new int[]{1,2,3,3,4,4,4,5,5,5},3);
        System.out.println(ret);
    }
}
