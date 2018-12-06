/*
LeetCode Q15 : 三数之和
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retval = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int lo = i + 1 , hi = nums.length - 1 , sum = 0 - nums[i];
                while(lo < hi){
                    if((nums[lo] + nums[hi]) == sum) {
                        retval.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo + 1])
                            lo++;
                        while(lo < hi && nums[hi] == nums[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    }
                    else if(nums[lo] + nums[hi] > sum){
                        hi--;
                    }
                    else {
                        lo++;
                    }
                }
            }
        }
        return retval;
    }

    public static void main(String args[]){
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> ret = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(ret);

    }
}
