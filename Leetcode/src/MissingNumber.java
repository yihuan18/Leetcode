/*
LeetCode Q268 : 缺失数字
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != i)
                return i;
        }
        return nums.length;
    }

    //使用求和的思想
    /*
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        int NSum = N*(N + 1) / 2;
        return NSum - sum;
    }
     */
}
