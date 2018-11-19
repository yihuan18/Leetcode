/*
Leetcode Q198
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class Rob {
    public int rob(int[] nums) {
        int M[] = new int[nums.length]; //max money containing i
        int maxRob = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(i == 0 || i == 1) {
                M[i] = nums[i];
                if(M[i] > maxRob)
                    maxRob = M[i];
            }
            else if(i == 2){
                M[i] = nums[i] + M[i-2];
                if(M[i] > maxRob)
                    maxRob = M[i];
            }
            else {
                M[i] = Math.max((nums[i] + M[i-2]),(nums[i] + M[i-3]));
                if(M[i] > maxRob)
                    maxRob = M[i];
            }
        }
        return maxRob;
    }


    /*
    public int rob(int[] nums) {
         if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int num=nums[0],max=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
           int temp=max;
            max=Math.max(num+nums[i],max);
            num=temp;
        }
        return max;
    }
     */

}
