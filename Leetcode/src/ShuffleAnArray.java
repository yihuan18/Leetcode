/*
leetcode Q198
你是一个专业的小偷，计划偷窃沿街的房屋。
每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统.
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    private int[] nums;
    private int[] original_num;
    public ShuffleAnArray(int[] nums){
        this.nums = Arrays.copyOf(nums,nums.length);
        original_num = Arrays.copyOf(nums,nums.length);
    }

    public int[] reset(){
        nums = Arrays.copyOf(original_num,original_num.length);
        return this.nums;
    }

    public int[] shuffle(){
        Random rand = new Random();
        for(int i = nums.length ; i > 0 ; i--){
            int index = rand.nextInt(i);
            int temp = nums[i-1];
            nums[i-1] = nums[index];
            nums[index] = temp;
        }
        return nums;
    }
}
