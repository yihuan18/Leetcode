class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1)
            return;
        int temp,index = 0,start = 0;
        int num = nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            index = (index+k)%nums.length;
            temp = nums[index];
            nums[index] = num;
            if(i == nums.length - 1)
                return;
            if(index == start){
                start++;
                index = start;
                num = nums[start];
            }else
                num = temp;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,2};
        solution.rotate(nums , 2);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}
