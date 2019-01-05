/*
Leetcode Q300 : 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。
（不需要连续）
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        if(N <= 1)
            return N;
        int maxIncreasingNum = 1;
        int increasingNum[] = new int[N];
        for(int i = 0 ; i < N ; i++)
            increasingNum[i] = 1;
        for(int i = 1 ; i < N ; i++){
            for(int j = i-1 ; j >= 0 ; j--){
                if(nums[i] > nums[j] && increasingNum[i] < increasingNum[j] + 1) {
                    increasingNum[i] = increasingNum[j] + 1;
                }
            }
            if(increasingNum[i] > maxIncreasingNum)
                maxIncreasingNum = increasingNum[i];
        }
        return maxIncreasingNum;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int ret = lis.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
        System.out.println(ret);
    }
}
