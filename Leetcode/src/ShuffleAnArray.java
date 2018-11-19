/*
leetcode Q384
打乱一个没有重复元素的数组。
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
