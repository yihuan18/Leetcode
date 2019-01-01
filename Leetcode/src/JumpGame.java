/*
Leetcode Q55 : 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length <=1)
            return true;
        int leftJump[] = new int[nums.length]; //当前位置剩余步数
        leftJump[0] = nums[0];
        for(int i = 1 ; i < nums.length-1 ; i++){
            if(leftJump[i-1] <= 0)
                return false;
            leftJump[i] = Math.max(leftJump[i-1]-1,nums[i]);
        }
        return (leftJump[nums.length-2] >=1 );
    }

    /*
    public boolean canJump(int[] nums) {
        int curMax = nums[0]; //curmax表示最远能够到达的位置
        for (int i = 1; i < nums.length; i++) {
            if (curMax < i) return false;
            curMax = Math.max(curMax, i + nums[i]);
        }
        return true;
    }
    */


    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        boolean ret = jg.canJump(new int[]{3,2,1,0,4});
        System.out.println(ret);
    }
}
