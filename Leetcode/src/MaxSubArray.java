/*
LeetCode Q53 : 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

public class MaxSubArray {
    //M[i]表示包含nums[i]的最大子序列值
    public int maxSubArray(int[] nums) {
        int M[] = new int[nums.length];
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(i == 0)
                M[i] = nums[0];
            else M[i] = Math.max(M[i-1] + nums[i] , nums[i]);
            maxValue = M[i] > maxValue ? M[i] : maxValue;
        }
        return maxValue;
    }
}
