import java.util.Arrays;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 1){
            if(nums[i] == nums[i+1])
                i += 2;
            else if(i == 0)
                return nums[0];
            else if(nums[i] == nums[i - 1])
                i++;
            else return nums[i];
        }
        return nums[i];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,2,3,2,3};
        int ret = solution.singleNumber(nums);
        System.out.print(ret);
    }
}
