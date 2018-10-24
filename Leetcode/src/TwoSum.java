import java.util.Arrays;
//找到数组中两个数之和为指定值
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++)
        {
            //if(nums[i] >= target)
                //break;
            int search = target - nums[i];
            for(int j = i + 1 ; j < nums.length ; j++) {
                if(nums[j] == search)
                    return new int[]{i,j};
                //else if(nums[j] > target)
                    //break;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();
        int ret[];
        ret = twoSum.twoSum(new int[]{3,2,4},6);
        for(int i:ret)
            System.out.print(i + " ");
    }
}
